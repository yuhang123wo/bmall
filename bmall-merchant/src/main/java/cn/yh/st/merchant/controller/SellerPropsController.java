/**
 * 
 */
package cn.yh.st.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.Props;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.config.shiro.ShiroUser;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.st.merchant.util.CategoryUtil;
import cn.yh.st.merchant.util.UserUtil;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.QueryCategoryVo;

/**
 * @author yuhang
 * @date 2019年7月3日
 * @desc
 */
@Controller
@RequestMapping("props")
public class SellerPropsController {

	@Autowired
	private ProductService productService;

	@GetMapping("listView")
	public String productView() {
		return "product/props-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Props>> listAttr(QueryAttrVo vo) {
		ShiroUser user = UserUtil.getUser();
		vo.setUserId(user.getId());
		return productService.listProps(vo);
	}

	@GetMapping("editPropsView/{id}")
	public String editPropsView(@PathVariable("id") Long id, Model model) {
		ApiResponseEnity<Props> p = productService.getPropsById(id);
		model.addAttribute("props", p.getData());
		if(p.getData()!=null) {
			ApiResponseEnity<Category> category = productService.getCategoryById(p.getData().getCategoryId());
			model.addAttribute("category", category.getData());
		}else {

			ShiroUser user = UserUtil.getUser();
			QueryCategoryVo v = new QueryCategoryVo();
			v.setState(State.ENABLE);
			v.setUserId(user.getId());
			List<Category> list = productService.listCategory(v).getData();
			model.addAttribute("listAll", CategoryUtil.getP(list));
		}
		
		return "product/props-edit";
	}

	@PostMapping("addProps")
	@ResponseBody
	public ApiResponseEnity<?> adddProps(Props props) {
		ShiroUser user = UserUtil.getUser();
		props.setUserId(user.getId());
		return productService.adddProps(props);
	}
	
	
	/**
	 * 
	 * @param propsId
	 * @param name
	 * @param data
	 * @return
	 */
	@PostMapping("updateProps")
	@ResponseBody
	public ApiResponseEnity<?> updateProps(Long propsId, String name, String data) {
		Props props = new Props();
		props.setId(propsId);
		props.setName(name);
		props.setData(data);
		ShiroUser user = UserUtil.getUser();
		props.setUserId(user.getId());
		return productService.updateProps(props);
	}
}
