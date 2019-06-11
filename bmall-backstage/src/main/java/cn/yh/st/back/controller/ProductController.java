/**
 * 
 */
package cn.yh.st.back.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.ProductStatus;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.Product;
import cn.yh.pojo.product.ProductAttr;
import cn.yh.pojo.product.ProductAttrValue;
import cn.yh.st.back.service.CategoryService;
import cn.yh.st.back.service.ProductAttrService;
import cn.yh.st.back.service.ProductService;
import cn.yh.st.back.vo.ProductVO;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.BasePage;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.AttrVo;
import cn.yh.vo.product.ProductAttrVo;
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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductAttrService productAttrService;

	@GetMapping("listProduct")
	@ResponseBody
	public ApiResponseEnity<Page<Product>> listProduct(@Validated QueryProductVo vo) {
		return productService.listProduct(vo);
	}

	@GetMapping("productListView")
	public String productListView() {
		return "product/product-list";
	}

	private List<Category> createZnodesByCateGory(List<Category> list) {
		List<Category> lz = new ArrayList<Category>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getpId().longValue() == 0) {
				lz.add(list.get(i));
			}
		}
		//
		for (int i = 0; i < lz.size(); i++) {
			Category g = lz.get(i);
			for (Category cate : list) {

				if (cate.getpId().longValue() == g.getId().longValue()) {
					lz.add(i + 1, cate);
				}
			}
		}
		return lz;
	}

	@GetMapping("productAddView")
	public String productAddView(Model model) {
		ApiResponseEnity<List<Category>> list = categoryService.listCategory(State.ENABLE);
		model.addAttribute("cateList", createZnodesByCateGory(list.getData()));
		return "product/product-add";
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addProduct")
	@ResponseBody
	public ApiResponseEnity<Boolean> addProduct(@Validated ProductVO vo, HttpServletRequest request) {
		// 取参数
		Map<String, Object> params = WebUtils.getParametersStartingWith(request, "");
		ApiResponseEnity<List<ProductAttrVo>> pv = productAttrService.listAttrByCategory(vo.getCategoryId());
		List<ProductAttrVo> list = pv.getData();
		List<AttrVo> listAttrVo = new ArrayList<AttrVo>();
		for (int i = 0; i < list.size(); i++) {
			AttrVo av = new AttrVo();
			ProductAttrVo pav = list.get(i);
			av.setAttrId(pav.getId());
			params.forEach((k, v) -> {
				if (pav.getCode().equals(k)) {
					List<ProductAttrValue> listPv = new ArrayList<ProductAttrValue>();
					if (v instanceof String[]) {
						String[] strs = (String[]) v;
						for (String str : strs) {
							ProductAttrValue p = new ProductAttrValue();
							p.setId(Long.parseLong(str));
							listPv.add(p);
						}
					}
					if (v instanceof String) {
						String str = (String) v;
						ProductAttrValue p = new ProductAttrValue();
						p.setId(Long.parseLong(str));
						listPv.add(p);
					}
					av.setList(listPv);
					listAttrVo.add(av);
				}
			});
		}
		AddProductVo addVo = new AddProductVo();
		addVo.setBarcode("barcode");
		addVo.setCategoryId(vo.getCategoryId());
		addVo.setDesc(vo.getRemark());
		addVo.setImg(vo.getTp()[0]);
		addVo.setKeywords(vo.getKeywords());
		addVo.setMarketPrice(new BigDecimal(vo.getMarketPrice()));
		addVo.setMarque("marque");
		addVo.setName(vo.getName());
		addVo.setPrice(new BigDecimal(vo.getPrice()));
		addVo.setStatus(ProductStatus.ON);
		addVo.setStock(1000);
		addVo.setTags("tags");
		addVo.setTypeId(1);
		addVo.setUserId(1L);
		addVo.setVideo("");
		addVo.setWeight(new BigDecimal(1));
		addVo.setAttrVo(listAttrVo);
		return productService.addProduct(addVo);
	}

	@GetMapping("productAttrView")
	public String productAttrView(Model model) {
		return "product/product-attr-list";
	}

	@GetMapping("productAttrList")
	@ResponseBody
	public ApiResponseEnity<Page<ProductAttr>> productAttrList(BasePage vo) {
		return productAttrService.listAttr(vo);
	}

	@GetMapping("productAttrValueList")
	@ResponseBody
	public ApiResponseEnity<List<ProductAttrValue>> productAttrValueList(long attrId) {
		return productAttrService.listAttrValue(attrId);
	}

	@PostMapping("updateAttrValueState")
	@ResponseBody
	public ApiResponseEnity<Boolean> updateAttrValueState(long id, State state) {
		return productAttrService.updateAttrValueState(id, state);
	}

	@PostMapping("updateAttrState")
	@ResponseBody
	public ApiResponseEnity<Boolean> updateAttrState(long id, State state) {
		return productAttrService.updateAttrState(id, state);
	}

	@PostMapping("addAttr")
	@ResponseBody
	public ApiResponseEnity<Boolean> addAttr(ProductAttr attr) {
		return productAttrService.addAttr(attr);
	}

	@PostMapping("addAttrValue")
	@ResponseBody
	public ApiResponseEnity<Boolean> addAttrValue(ProductAttrValue attrValue) {
		return productAttrService.addAttrValue(attrValue);
	}

	@GetMapping("listAttrByCategory")
	@ResponseBody
	ApiResponseEnity<List<ProductAttrVo>> listAttrByCategory(Long categoryId) {
		return productAttrService.listAttrByCategory(categoryId);
	}
}