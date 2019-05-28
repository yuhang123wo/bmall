/**
 * 
 */
package cn.yh.st.back.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Product;
import cn.yh.st.back.service.ProductService;
import cn.yh.st.back.vo.ProductVO;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.product.QueryProductVo;

/**
 * @author yuhang
 * @date 2019年5月22日
 * @desc
 */
@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("listProduct")
	@ResponseBody
	public ApiResponseEnity<Page<Product>> listProduct(@Validated QueryProductVo vo) {
		return productService.listProduct(vo);
	}

	@GetMapping("productListView")
	public String productListView() {
		return "product/product-list";
	}

	@GetMapping("productAddView")
	public String productAddView() {
		return "product/product-add";
	}

	@PostMapping("addProduct")
	@ResponseBody
	public ApiResponseEnity<Boolean> addProduct(ProductVO vo) {
		return new ApiResponseEnity<Boolean>();
	}

 
}