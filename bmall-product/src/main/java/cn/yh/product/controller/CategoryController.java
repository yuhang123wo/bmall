/**
 * 
 */
package cn.yh.product.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.product.service.ICategoryService;
import cn.yh.st.common.api.ApiResponseEnity;

/**
 * @author yuhang
 * @date 2019年5月15日
 * @desc 商品类目
 */
@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	/**
	 * 取所有分类
	 * 
	 * @return
	 */
	@GetMapping("listCategory")
	public ApiResponseEnity<List<Category>> listCategory(State state) {
		QueryWrapper<Category> query = new QueryWrapper<Category>();
		if (null != state) {
			query.eq("state", state);
		}
		return new ApiResponseEnity<List<Category>>(categoryService.list(query));
	}

	/**
	 * 新增或修改分类
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("addOrderCategory")
	public ApiResponseEnity<Boolean> addOrderCategory(@RequestBody Category category) {
		int count = categoryService.count(new QueryWrapper<Category>().eq("category_name", category.getCategoryName()));
		if (count > 0) {
			return new ApiResponseEnity<Boolean>().fail("分类名重复");
		}
		category.setUpdateTime(new Date());
		boolean flag = categoryService.save(category);
		if (flag)
			return new ApiResponseEnity<Boolean>();
		return new ApiResponseEnity<Boolean>().fail("添加失败稍后再试");
	}

	/**
	 * 更新分类状态
	 * 
	 * @param categoryId
	 * @param state
	 * @return
	 */
	@PostMapping("updateCategoryState")
	public ApiResponseEnity<Boolean> updateCategoryState(Long categoryId, State state) {
		Category category = categoryService.getById(categoryId);
		if (category == null) {
			return new ApiResponseEnity<Boolean>().fail("未查询到此分类");
		}
		category.setState(state);
		boolean flag = categoryService.updateById(category);
		if (flag)
			return new ApiResponseEnity<Boolean>();
		return new ApiResponseEnity<Boolean>().fail("修改状态失败");
	}
}
