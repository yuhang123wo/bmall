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
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.dto.SpecValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Spec;
import cn.yh.pojo.product.SpecValue;
import cn.yh.product.service.ISpecService;
import cn.yh.product.service.ISpecValueService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.AddAttrValueVo;
import cn.yh.vo.product.AddSpecVo;
import cn.yh.vo.product.QuerySpecVo;
import cn.yh.vo.product.UpdateStateVo;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc 规格相关接口
 */
@RestController
@RequestMapping("spec")
public class SpecController {

	@Autowired
	private ISpecService specService;

	@Autowired
	private ISpecValueService specValueService;

	/**
	 * 规格列表
	 * 
	 * @param vo
	 * @return
	 */
	@GetMapping("listSpec")
	public ApiResponseEnity<Page<Spec>> listAttr(QuerySpecVo vo) {
		QueryWrapper<Spec> queryWrapper = SearchToQuery.getQuery(vo);
		Page<Spec> page = new Page<Spec>(vo.getPageNo(), vo.getPageSize());
		IPage<Spec> attrList = specService.page(page, queryWrapper);
		return new ApiResponseEnity<Page<Spec>>((Page<Spec>) attrList);
	}

	/**
	 * 规格值
	 * 
	 * @param attrIds
	 * @return
	 */
	@GetMapping("listSpecValue")
	public ApiResponseEnity<?> listAttrValue(@Validated @NotBlank String specIds, @Validated @NotBlank State state) {
		List<SpecValueDto> list = specValueService.listSpecValueDto(specIds.split(","), state);
		return new ApiResponseEnity<>(list);
	}

	/**
	 * 规格添加
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addSpecAndValue")
	public ApiResponseEnity<?> addSpecAndValue(@Validated @RequestBody AddSpecVo vo) {
		specService.addSpecValue(vo);
		return new ApiResponseEnity<>();
	}

	/**
	 * 修改规格状态
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateSpecState")
	public ApiResponseEnity<?> updateAttrState(@Validated @RequestBody UpdateStateVo vo) {
		Spec attr = specService.getById(vo.getId());
		if (attr == null) {
			return new ApiResponseEnity<>().fail("规格不存");
		}

		attr.setState(vo.getState());

		Boolean flag = specService.updateById(attr);
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
	@PostMapping("updateSpecValueState")
	public ApiResponseEnity<?> updateAttrValueState(@Validated @RequestBody UpdateStateVo vo) {
		SpecValue attr = specValueService.getById(vo.getId());
		if (attr == null) {
			return new ApiResponseEnity<>().fail("属性值不存");
		}

		attr.setState(vo.getState());

		Boolean flag = specValueService.updateById(attr);
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
	@PostMapping("addSpecValue")
	public ApiResponseEnity<?> addAttrValue(@Validated @RequestBody AddAttrValueVo vo) {
		Spec attr = specService.getById(vo.getAttrId());
		if (attr == null || attr.getState() == State.DISABLE) {
			return new ApiResponseEnity<>().fail("属性不存或已被禁用");
		}

		List<SpecValue> list = new ArrayList<SpecValue>();

		for (int i = 0; i < vo.getList().size(); i++) {
			SpecValue v = new SpecValue();
			v.setSpecId(attr.getId());
			v.setCreateTime(new Date());
			v.setUpdateTime(v.getCreateTime());
			v.setState(State.ENABLE);
			v.setvName(vo.getList().get(i));
			list.add(v);
		}
		boolean flag = specValueService.saveBatch(list, list.size());
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("添加失败");
	}
}
