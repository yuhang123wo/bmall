/**
 * 
 */
package cn.yh.st.back.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.ProductStatus;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.Product;
import cn.yh.st.back.service.CategoryService;
import cn.yh.st.back.service.ProductService;
import cn.yh.st.back.vo.ProductVO;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.product.AddProductVo;
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
	public ApiResponseEnity<Boolean> addProduct(@Validated ProductVO vo) {
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
		return productService.addProduct(addVo);
	}

}