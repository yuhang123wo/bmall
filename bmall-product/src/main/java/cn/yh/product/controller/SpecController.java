/**
 * 
 */
package cn.yh.product.controller;

import java.util.Date;

import javax.swing.JPopupMenu.Separator;

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

import cn.yh.pojo.product.Spec;
import cn.yh.product.service.ISpecService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.MallUtil;
import cn.yh.st.common.util.SearchToQuery;
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

	/**
	 * 规格列表
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listSpec")
	public ApiResponseEnity<Page<Spec>> listAttr(@RequestBody QuerySpecVo vo) {
		QueryWrapper<Spec> queryWrapper = SearchToQuery.getQuery(vo);
		queryWrapper.and(obj -> obj.eq("user_id", 0).or().eq("user_id", vo.getUserId()));
		Page<Spec> page = new Page<Spec>(vo.getPageNo(), vo.getPageSize());
		IPage<Spec> attrList = specService.page(page, queryWrapper);
		return new ApiResponseEnity<Page<Spec>>((Page<Spec>) attrList);
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
		if (MallUtil.longEqZero(vo.getUserId())) {
			return new ApiResponseEnity<>().fail("系统属性不能修改");
		}
		attr.setState(vo.getState());

		Boolean flag = specService.update(attr,
				new UpdateWrapper<Spec>().eq("user_id", vo.getUserId()).eq("id", vo.getId()));
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
	@PostMapping("updateAttrAndValue")
	public ApiResponseEnity<?> updateAttrAndValue(@Validated @RequestBody Spec vo) {
		Spec spec = specService.getOne(new QueryWrapper<Spec>().eq("id", vo.getId()).eq("user_id", vo.getUserId()));
		if (spec == null) {
			return new ApiResponseEnity<>().fail("规格不存在");
		}

		spec.setName(vo.getName());
		spec.setData(vo.getData());
		spec.setUpdateTime(new Date());
		boolean flag = specService.updateById(spec);
		if (flag)
			return new ApiResponseEnity<>();
		return new ApiResponseEnity<>().fail("添加失败");
	}
	
	
	@GetMapping("getSpecById")
	public ApiResponseEnity<?> getSpecById(@RequestParam Long id) {
		return new ApiResponseEnity<>(specService.getById(id));
	}
}
