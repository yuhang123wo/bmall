/**
 * 
 */
package cn.yh.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yh.product.service.IProductService;

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

}
