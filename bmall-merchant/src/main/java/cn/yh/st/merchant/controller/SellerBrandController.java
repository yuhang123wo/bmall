/**
 * 
 */
package cn.yh.st.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Brand;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.config.shiro.ShiroUser;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.st.merchant.util.UserUtil;
import cn.yh.vo.product.QueryAttrVo;

/**
 * @author yuhang
 * @date 2019年7月11日
 * @desc
 */
@Controller
@RequestMapping("brand")
public class SellerBrandController {
	@Autowired
	private ProductService productService;

	@GetMapping("listView")
	public String productView(Model model) {
		return "product/brand-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Brand>> listAttr(QueryAttrVo vo) {
		ShiroUser user = UserUtil.getUser();
		vo.setUserId(user.getId());
		return productService.listBrand(vo);
	}

	@GetMapping("editBrandView/{id}")
	public String editBrandView(@PathVariable("id") Long id, Model model) {
		ApiResponseEnity<Brand> p = productService.getBrandById(id);
		model.addAttribute("brand", p.getData());
		return "product/brand-edit";
	}

	/**
	 * 
	 * @param attr
	 * @return
	 */
	@PostMapping("addOrUpdateBrand")
	@ResponseBody
	public ApiResponseEnity<?> addOrUpdateBrand(Brand brand) {
		ShiroUser user = UserUtil.getUser();
		brand.setUserId(user.getId());
		return productService.addOrUpdateBrand(brand);
	}
}
