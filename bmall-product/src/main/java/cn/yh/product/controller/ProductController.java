/**
 * 
 */
package cn.yh.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Product;
import cn.yh.product.service.IProductService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.QueryProductVo;

/**
 * @author yuhang
 * @date 2019年5月15日
 * @desc
 */
@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private IProductService productService;

	/**
	 * 查询商品
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listProduct")
	public ApiResponseEnity<Page<Product>> listProduct(@RequestBody @Validated QueryProductVo vo) {
		Page<Product> page = new Page<Product>(vo.getPageNo(), vo.getPageSize());
		QueryWrapper<Product> queryWrapper = SearchToQuery.getQuery(vo);

		if (vo.getCategoryId() != null) {
			queryWrapper.inSql("category_id",
					"select id from category where id=" + vo.getCategoryId() + " or p_id=" + vo.getCategoryId());
		}
		queryWrapper.orderByDesc("id");
		return new ApiResponseEnity<Page<Product>>((Page<Product>) productService.page(page, queryWrapper));
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addProduct")
	public ApiResponseEnity<Boolean> addProduct(@Validated @RequestBody AddProductVo vo) {
		return new ApiResponseEnity<Boolean>();
	}

}
