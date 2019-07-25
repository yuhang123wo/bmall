/**
 * 
 */
package cn.yh.st.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.Product;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.config.shiro.ShiroUser;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.st.merchant.util.CategoryUtil;
import cn.yh.st.merchant.util.UserUtil;
import cn.yh.st.merchant.vo.PVo;
import cn.yh.vo.product.QueryCategoryVo;
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

	@GetMapping("productAddView")
	public String productAddview(Model model) {
		ShiroUser user = UserUtil.getUser();
		QueryCategoryVo vo = new QueryCategoryVo();
		vo.setUserId(user.getId());
		List<Category> list = productService.listCategory(vo).getData();
		model.addAttribute("category", CategoryUtil.getP(list));
		return "product/product-add";
	}

	@GetMapping("getProductPros")
	@ResponseBody
	public ApiResponseEnity<?> getProductPros(Long categoryId) {
		return productService.getProductProperty(categoryId == null ? 0 : categoryId, UserUtil.getUser().getId());
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addProduct")
	@ResponseBody
	public ApiResponseEnity<?> addProduct(@RequestBody  PVo vo) {
		ShiroUser user = UserUtil.getUser();
		return null;
	}

}
