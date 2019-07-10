/**
 * 
 */
package cn.yh.product.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.dto.AttrValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.AttrValue;
import cn.yh.product.service.IAttrService;
import cn.yh.product.service.IAttrValueService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.MallUtil;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.AddAttrValueVo;
import cn.yh.vo.product.AddAttrVo;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.UpdateStateVo;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
@RestController
@RequestMapping("attr")
public class AttrController {

	@Autowired
	private IAttrService attrService;

	@Autowired
	private IAttrValueService attrValueService;

	/**
	 * 属性列表
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listAttr")
	public ApiResponseEnity<Page<Attr>> listAttr(@RequestBody QueryAttrVo vo) {
		QueryWrapper<Attr> queryWrapper = SearchToQuery.getQuery(vo);
		queryWrapper.and(obj -> obj.eq("user_id", 0).or().eq("user_id", vo.getUserId()));
		Page<Attr> page = new Page<Attr>(vo.getPageNo(), vo.getPageSize());
		IPage<Attr> attrList = attrService.page(page, queryWrapper);
		return new ApiResponseEnity<Page<Attr>>((Page<Attr>) attrList);
	}

	/**
	 * 属性值
	 * 
	 * @param attrIds
	 * @return
	 */
	@GetMapping("listAttrValue")
	public ApiResponseEnity<?> listAttrValue(@Validated @NotBlank String attrIds, @Validated @NotBlank State state) {
		List<AttrValueDto> list = attrValueService.listAttrValueDto(attrIds.split(","), state);
		return new ApiResponseEnity<>(list);
	}

	/**
	 * 属性添加
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addAttrAndValue")
	public ApiResponseEnity<?> addAttrAndValue(@Validated @RequestBody AddAttrVo vo) {
		attrService.addAttrValue(vo);
		return new ApiResponseEnity<>();
	}

	/**
	 * 修改属性
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateAttrState")
	public ApiResponseEnity<?> updateAttrState(@Validated @RequestBody UpdateStateVo vo) {
		Attr attr = attrService.getById(vo.getId());
		if (attr == null) {
			return new ApiResponseEnity<>().fail("属性不存");
		}
		if(MallUtil.longEqZero(vo.getUserId())) {
			return new ApiResponseEnity<>().fail("系统属性不能修改");
		}
		attr.setState(vo.getState());
		Boolean flag = attrService.update(attr, new UpdateWrapper<Attr>().eq("user_id", vo.getUserId()).eq("id",vo.getId()));
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("修改失败");
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateAttrValueState")
	public ApiResponseEnity<?> updateAttrValueState(@Validated @RequestBody UpdateStateVo vo) {
		AttrValue attr = attrValueService.getById(vo.getId());
		if (attr == null) {
			return new ApiResponseEnity<>().fail("属性值不存");
		}
		if(MallUtil.longEqZero(vo.getUserId())) {
			return new ApiResponseEnity<>().fail("系统属性不能修改");
		}
		attr.setState(vo.getState());
		Boolean flag = attrValueService.update(attr, new UpdateWrapper<AttrValue>().eq("user_id", vo.getUserId()).eq("id",vo.getId()));
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("修改失败");
	}

	/**
	 * 新增属性值
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addAttrValue")
	public ApiResponseEnity<?> addAttrValue(@Validated @RequestBody AddAttrValueVo vo) {
		Attr attr = attrService.getById(vo.getAttrId());
		if (attr == null || attr.getState() == State.DISABLE) {
			return new ApiResponseEnity<>().fail("属性不存或已被禁用");
		}
		if (attr.getUserId().longValue() != 0 && attr.getUserId().longValue() != vo.getUserId().longValue()) {
			return new ApiResponseEnity<>().fail("无权限操作");
		}
		List<AttrValue> list = new ArrayList<AttrValue>();
		for (int i = 0; i < vo.getList().size(); i++) {
			AttrValue v = new AttrValue();
			v.setAttrId(attr.getId());
			v.setCreateTime(new Date());
			v.setUpdateTime(v.getCreateTime());
			v.setState(State.ENABLE);
			v.setvName(vo.getList().get(i));
			v.setUserId(vo.getUserId());
			list.add(v);
		}
		boolean flag = attrValueService.saveBatch(list, list.size());
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("添加失败");
	}
}
