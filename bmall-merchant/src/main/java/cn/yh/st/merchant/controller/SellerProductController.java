/**
 * 
 */
package cn.yh.st.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Product;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.vo.product.QueryProductVo;

/**
 * @author yuhang
 * @date 2019年7月3日
 * @desc
 */
@Controller
@RequestMapping("product")
public class SellerProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 商品管理视图
	 * 
	 * @return
	 */
	@GetMapping("listView")
	public String productView() {
		return "product/product-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Product>> listProduct(@Validated QueryProductVo vo) {
		return productService.listProduct(vo);
	}

}