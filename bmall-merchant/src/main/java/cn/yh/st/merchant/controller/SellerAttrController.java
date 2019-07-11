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
import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.Category;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.config.shiro.ShiroUser;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.st.merchant.util.CategoryUtil;
import cn.yh.st.merchant.util.UserUtil;
import cn.yh.st.merchant.vo.AttrVO;
import cn.yh.vo.product.AddAttrVo;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.QueryCategoryVo;

/**
 * @author yuhang
 * @date 2019年7月3日
 * @desc
 */
@Controller
@RequestMapping("attr")
public class SellerAttrController {

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
		return "product/attr-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Attr>> listAttr(QueryAttrVo vo) {
		ShiroUser user = UserUtil.getUser();
		vo.setUserId(user.getId());
		return productService.listAttr(vo);
	}
	
	@GetMapping("editAttrView/{id}")
	public String editAttrView(@PathVariable("id") Long id, Model model) {
		ApiResponseEnity<Attr> p = productService.getAttrById(id);
		model.addAttribute("attr", p.getData());
		ApiResponseEnity<Category> category = productService.getCategoryById(p.getData().getCategoryId());
		model.addAttribute("category", category.getData());
		return "product/attr-edit";
	}
	
	@GetMapping("addAttrView")
	public String addAttrView( Model model) {
		ShiroUser user = UserUtil.getUser();
		QueryCategoryVo v = new QueryCategoryVo();
		v.setState(State.ENABLE);
		v.setUserId(user.getId());
		List<Category> list = productService.listCategory(v).getData();
		model.addAttribute("listAll", CategoryUtil.getP(list));
		return "product/attr-add";
	}
	/**
	 * 
	 * @param attr
	 * @return
	 */
	@PostMapping("addAttrAndValue")
	@ResponseBody
	public ApiResponseEnity<?> addAttrAndValue(AttrVO attr){
		AddAttrVo vo = new AddAttrVo();
		ShiroUser user = UserUtil.getUser();
		vo.setUserId(user.getId());
		vo.setCategoryId(attr.getCategoryId());
		vo.setName(attr.getName());
		vo.setState(State.ENABLE);
	    vo.setList(attr.getData());
	    if(CollectionUtils.isEmpty(attr.getData())) {
	    	return new ApiResponseEnity<>().fail("可选项必须大于0，且不为空");
	    }
		if (attr.getData().size() > 10) {
			return new ApiResponseEnity<>().fail("可选项最多20");
		}
		return productService.addAttrAndValue(vo);
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateAttrAndValue")
	@ResponseBody
	public ApiResponseEnity<?> updateAttrAndValue(Attr vo){
		vo.setUserId(UserUtil.getUser().getId());
		return productService.updateAttrAndValue(vo);
		
	}
}
