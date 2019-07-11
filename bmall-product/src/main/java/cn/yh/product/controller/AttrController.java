/**
 * 
 */
package cn.yh.product.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Attr;
import cn.yh.product.service.IAttrService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.MallUtil;
import cn.yh.st.common.util.SearchToQuery;
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

	@GetMapping("getAttrById")
	public ApiResponseEnity<Attr> getAttrById(@RequestParam Long id) {
		Attr attr = attrService.getById(id);
		return new ApiResponseEnity<Attr>(attr);
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
		if (MallUtil.longEqZero(vo.getUserId())) {
			return new ApiResponseEnity<>().fail("系统属性不能修改");
		}
		attr.setState(vo.getState());
		Boolean flag = attrService.update(attr,
				new UpdateWrapper<Attr>().eq("user_id", vo.getUserId()).eq("id", vo.getId()));
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("修改失败");
	}

	@PostMapping("updateAttrAndValue")
	public ApiResponseEnity<?> updateAttrAndValue(@Validated @RequestBody Attr vo) {
		Attr attr = attrService.getOne(new QueryWrapper<Attr>().eq("id", vo.getId()).eq("user_id", vo.getUserId()));
		if (attr == null) {
			return new ApiResponseEnity<>().fail("属性不存在");
		}
		attr.setName(vo.getName());
		attr.setData(vo.getData());
		attr.setUpdateTime(new Date());
		boolean flag = attrService.updateById(attr);
		if (flag)
			return new ApiResponseEnity<>();
		return new ApiResponseEnity<>().fail("失败");
	}
}
