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

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Brand;
import cn.yh.product.service.IBrandService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.MallUtil;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.UpdateStateVo;

/**
 * @author yuhang
 * @date 2019年7月11日
 * @desc
 */
@RestController
@RequestMapping("brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;

	@PostMapping("listBrand")
	public ApiResponseEnity<IPage<Brand>> listBrand(@RequestBody QueryAttrVo vo) {
		QueryWrapper<Brand> queryWrapper = SearchToQuery.getQuery(vo);
		queryWrapper.and(obj -> obj.eq("user_id", 0).or().eq("user_id", vo.getUserId()));
		Page<Brand> page = new Page<Brand>(vo.getPageNo(), vo.getPageSize());
		IPage<Brand> attrList = brandService.page(page, queryWrapper);
		return new ApiResponseEnity<IPage<Brand>>(attrList);
	}

	@GetMapping("getBrandById")
	public ApiResponseEnity<Brand> getBrandById(@RequestParam Long id) {
		Brand attr = brandService.getById(id);
		return new ApiResponseEnity<Brand>(attr);
	}

	@PostMapping("addOrUpdateBrand")
	public ApiResponseEnity<?> addOrUpdateBrand(@Validated @RequestBody Brand vo) {
		boolean flag = false;
		if (vo.getId() == null) {
			vo.setState(State.ENABLE);
			vo.setCreateTime(new Date());
			vo.setUpdateTime(vo.getCreateTime());
			flag = brandService.save(vo);
		} else {
			Brand attr = brandService
					.getOne(new QueryWrapper<Brand>().eq("id", vo.getId()).eq("user_id", vo.getUserId()));
			if (attr == null) {
				return new ApiResponseEnity<>().fail("品牌不存在");
			}
			attr.setLogo(vo.getLogo());
			attr.setAddress(vo.getAddress());
			flag = brandService.updateById(attr);
		}
		if (flag)
			return new ApiResponseEnity<>();
		return new ApiResponseEnity<>().fail("失败");
	}

	/**
	 * 修改属性
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateBrandState")
	public ApiResponseEnity<?> updateAttrState(@Validated @RequestBody UpdateStateVo vo) {
		Brand attr = brandService.getById(vo.getId());
		if (attr == null) {
			return new ApiResponseEnity<>().fail("品牌不存在");
		}
		if (MallUtil.longEqZero(vo.getUserId())) {
			return new ApiResponseEnity<>().fail("系统属性不能修改");
		}
		attr.setState(vo.getState());
		Boolean flag = brandService.update(attr,
				new UpdateWrapper<Brand>().eq("user_id", vo.getUserId()).eq("id", vo.getId()));
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("修改失败");
	}

}
