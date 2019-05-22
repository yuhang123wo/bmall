/**
 * 
 */
package cn.yh.st.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.st.back.service.CategoryService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.user.Znodes;

/**
 * @author yuhang
 * @date 2019年5月16日
 * @desc
 */
@Controller
@RequestMapping("cate")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	private List<Znodes> createZnodesByCateGory(List<Category> list) {
		List<Znodes> lz = new ArrayList<Znodes>();
		for (int i = 0; i < list.size(); i++) {
			Category cate = list.get(i);
			Znodes nodes = new Znodes();
			nodes.setId(cate.getId().intValue());
			nodes.setName(cate.getCategoryName());
			nodes.setOpen(true);
			nodes.setpId(cate.getpId());
			lz.add(nodes);
		}
		return lz;
	}

	@GetMapping("categoryListView")
	public String categoryListView(Model model) {
		ApiResponseEnity<List<Category>> list = categoryService.listCategory(State.ENABLE);
		model.addAttribute("cateList", createZnodesByCateGory(list.getData()));
		return "category/cate-list";
	}
}
