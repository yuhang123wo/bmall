/**
 * 
 */
package cn.yh.product.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.product.config.ProductConstant;
import cn.yh.product.service.ICategoryService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.MallUtil;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.QueryCategoryVo;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	/**
	 * 按条件查询分类列表
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listCategory")
	public ApiResponseEnity<IPage<Category>> listCategory(QueryCategoryVo vo) {
		Page<Category> page = new Page<Category>(vo.getPageNo(), vo.getPageSize());
		QueryWrapper<Category> queryWrapper = SearchToQuery.getQuery(vo);
		return new ApiResponseEnity<IPage<Category>>(categoryService.page(page, queryWrapper));
	}

	/**
	 * 新增分类
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addCategory")
	public ApiResponseEnity<?> addCategory(@RequestBody @Validated Category vo) {
		if (MallUtil.longGtZero(vo.getpId())) {
			Category category = categoryService.getById(vo.getpId());
			if (category == null) {
				return new ApiResponseEnity<>().fail("错误的父分类");
			}
			if (category.getLevel() >= ProductConstant.MAX_LIMIT_CATEGORY_LEVEL) {
				return new ApiResponseEnity<>().fail("分类最多三级");
			}
			vo.setLevel(category.getLevel() + 1);
		} else {
			// 没有父ID则为第一级
			vo.setLevel(1);
		}
		vo.setUpdateTime(new Date());
		vo.setCreateTime(new Date());
		boolean flag = categoryService.save(vo);
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("新增分类失败稍后再试");
	}

	/**
	 * 修改分类状态
	 * 
	 * @param categoryId
	 * @param state
	 * @return
	 */
	@PostMapping("updateCategoryState")
	public ApiResponseEnity<?> updateCategoryState(Long categoryId, State state) {
		Category category = categoryService.getById(categoryId);
		if (category == null) {
			return new ApiResponseEnity<>().fail("错误的分类");
		}
		category.setState(state);
		boolean flag = categoryService.updateById(category);
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("修改失败稍后再试");
	}

}
