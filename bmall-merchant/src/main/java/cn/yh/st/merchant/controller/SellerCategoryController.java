/**
 * 
 */
package cn.yh.st.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.Product;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.QueryCategoryVo;

/**
 * @author yuhang
 * @date 2019年7月5日
 * @desc
 */
@Controller
@RequestMapping("category")
public class SellerCategoryController {

	@Autowired
	private ProductService productService;

	@GetMapping("listView")
	public String productView() {
		return "product/category-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Category>> listAttr(QueryCategoryVo vo) {
		return productService.listCategory(vo);
	}
}
