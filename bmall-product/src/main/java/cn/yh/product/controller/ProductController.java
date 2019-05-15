/**
 * 
 */
package cn.yh.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Product;
import cn.yh.st.common.api.ApiResponseEnity;

/**
 * @author yuhang
 * @date 2019年5月15日
 * @desc
 */
@RestController
@RequestMapping("product")
public class ProductController {

	public ApiResponseEnity<Page<Product>> listProduct() {
		return null;
	}
}
