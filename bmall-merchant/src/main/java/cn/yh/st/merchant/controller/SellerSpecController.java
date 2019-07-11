/**
 * 
 */
package cn.yh.st.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.Spec;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.config.shiro.ShiroUser;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.st.merchant.util.CategoryUtil;
import cn.yh.st.merchant.util.UserUtil;
import cn.yh.vo.product.AddSpecVo;
import cn.yh.vo.product.QueryCategoryVo;
import cn.yh.vo.product.QuerySpecVo;

/**
 * @author yuhang
 * @date 2019年7月3日
 * @desc
 */
@Controller
@RequestMapping("spec")
public class SellerSpecController {
	@Autowired
	private ProductService productService;

	@GetMapping("listView")
	public String productView(Model model) {
		ShiroUser user = UserUtil.getUser();
		QueryCategoryVo v = new QueryCategoryVo();
		v.setState(State.ENABLE);
		v.setUserId(user.getId());
		List<Category> list = productService.listCategory(v).getData();
		model.addAttribute("listAll", CategoryUtil.getP(list));
		return "product/spec-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Spec>> listAttr(QuerySpecVo vo) {
		ShiroUser user = UserUtil.getUser();
		vo.setUserId(user.getId());
		return productService.listSpec(vo);
	}

	@GetMapping("editSpecView/{id}")
	public String editSpecView(@PathVariable("id") Long id, Model model) {
		ApiResponseEnity<Spec> p = productService.getSpecById(id);
		model.addAttribute("attr", p.getData());
		ApiResponseEnity<Category> category = productService.getCategoryById(p.getData().getCategoryId());
		model.addAttribute("category", category.getData());
		return "product/spec-edit";
	}

	@GetMapping("addSpecView")
	public String addSpecView(Model model) {
		ShiroUser user = UserUtil.getUser();
		QueryCategoryVo v = new QueryCategoryVo();
		v.setState(State.ENABLE);
		v.setUserId(user.getId());
		List<Category> list = productService.listCategory(v).getData();
		model.addAttribute("listAll", CategoryUtil.getP(list));
		return "product/spec-add";
	}

	/**
	 * 
	 * @param attr
	 * @return
	 */
	@PostMapping("addSpecAndValue")
	@ResponseBody
	public ApiResponseEnity<?> addSpecAndValue(AddSpecVo attr) {
		ShiroUser user = UserUtil.getUser();
		attr.setUserId(user.getId());
		attr.setState(State.ENABLE);
		if (CollectionUtils.isEmpty(attr.getList())) {
			return new ApiResponseEnity<>().fail("可选项必须大于0，且不为空");
		}
		if (attr.getList().size() > 10) {
			return new ApiResponseEnity<>().fail("可选项最多20");
		}
		return productService.addSpecAndValue(attr);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateSpecAndValue")
	@ResponseBody
	public ApiResponseEnity<?> updateSpecAndValue(Spec vo) {
		vo.setUserId(UserUtil.getUser().getId());
		return productService.updateSpecAndValue(vo);

	}
}
