/**
 * 
 */
package cn.yh.st.merchant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.MallUtil;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.st.merchant.vo.CategoryVO;
import cn.yh.util.ConvertUtil;
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
	public ApiResponseEnity<List<CategoryVO>> listAttr(QueryCategoryVo vo) {
		List<Category> list = productService.listCategory(vo).getData();
		return new ApiResponseEnity<List<CategoryVO>>(getP(list));
	}

	/**
	 * 
	 * @param treeNodes
	 * @return
	 */
	private List<CategoryVO> getP(List<Category> treeNodes) {
		List<CategoryVO> trees = new ArrayList<CategoryVO>();
		for (Category treeNode : treeNodes) {
			trees.add(ConvertUtil.convert(treeNode, CategoryVO.class));
		}
		List<CategoryVO> result = new ArrayList<CategoryVO>();
		for (CategoryVO treeNode : trees) {
			if (treeNode.getpId().longValue() == 0) {
				treeNode.setList(buildTree(trees, treeNode.getId()));
				result.add(treeNode);
			}
		}
		return result;
	}

	private List<CategoryVO> buildTree(List<CategoryVO> list, long parentId) {
		List<CategoryVO> voList = new ArrayList<CategoryVO>();
		for (CategoryVO v : list) {
			long pid = v.getpId();
			if (parentId == pid) {
				List<CategoryVO> menuLists = buildTree(list, v.getId());
				v.setList(menuLists);
				voList.add(v);
			}
		}
		return voList;
	}

	@GetMapping("editCategoryView/{id}")
	public String editCategoryView(Model model, @PathVariable("id") Long id) {
		if (id != null && id.longValue() > 0) {
			Category category = productService.getCategoryById(id).getData();
			model.addAttribute("category", category);
		}
		List<Category> list = productService.listCategory(new QueryCategoryVo()).getData();
		model.addAttribute("listAll", getP(list));
		return "product/category-edit";
	}

	@PostMapping("addCategory")
	@ResponseBody
	public ApiResponseEnity<?> addCategory(@Validated Category vo) {
		return productService.addCategory(vo);
	}

	@PostMapping("updateCategoryState")
	public ApiResponseEnity<?> updateCategoryState(Long id, State state) {
		if (MallUtil.longGtZero(id)) {
			return new ApiResponseEnity<>().fail("错误的分类");
		}
		return productService.updateCategoryState(id, state);
	}
}
