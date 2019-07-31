/**
 * 
 */
package cn.yh.st.merchant.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import cn.yh.st.merchant.vo.Fb;
import cn.yh.st.merchant.vo.Fc;
import cn.yh.st.merchant.vo.Fd;
import cn.yh.st.merchant.vo.Nv;
import cn.yh.st.merchant.vo.PVo;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.NameValue;
import cn.yh.vo.product.PAttr;
import cn.yh.vo.product.Pprops;
import cn.yh.vo.product.QueryCategoryVo;
import cn.yh.vo.product.QueryProductVo;
import cn.yh.vo.product.SKu;
import cn.yh.vo.product.SKuProps;
import cn.yh.vo.product.SkuValues;

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
	public ApiResponseEnity<?> addProduct(@RequestBody PVo vo) {
		ShiroUser user = UserUtil.getUser();
		AddProductVo productVo = new AddProductVo();
		productVo.setBrandId(vo.getForm1().getBrandId());
		productVo.setCategoryId(vo.getForm1().getCategroyId());
		productVo.setImg(vo.getForm1().getImg());
		productVo.setKeywords(vo.getForm1().getKeywords());
		productVo.setName(vo.getForm1().getName());
		productVo.setPno(vo.getForm1().getPno());
		productVo.setTags(vo.getForm1().getTags());
		productVo.setUserId(user.getId());
		productVo.setVideo("");
		if (StringUtils.isNotBlank(vo.getForm1().getWeight())) {
			productVo.setWeight(new BigDecimal(vo.getForm1().getWeight()));
		} else {
			productVo.setWeight(BigDecimal.ZERO);
		}
		productVo.setWeightUnit("KG");
		// attr
		List<PAttr> attrList = new ArrayList<PAttr>();
		List<Nv> list = vo.getForm3();
		for (int i = 0; i < list.size(); i++) {
			Nv nv = list.get(i);
			PAttr attr = new PAttr();
			attr.setId(nv.getId());
			attr.setValues(nv.getValue());
			attrList.add(attr);
		}
		productVo.setAttrList(attrList);
		// props
		List<Fb> list2 = vo.getForm2();
		List<Pprops> propsList = new ArrayList<Pprops>();
		for (int i = 0; i < list.size(); i++) {
			Fb fb = list2.get(i);
			Pprops p = new Pprops();
			p.setId(fb.getId());
			p.setGroupName(fb.getGroup());
			List<NameValue> nvList = new ArrayList<NameValue>();
			for (Nv nv : fb.getData()) {
				NameValue v = new NameValue();
				v.setName(nv.getName());
				v.setValue(nv.getValue());
				nvList.add(v);
			}
			p.setList(nvList);
			propsList.add(p);
		}
		productVo.setPropsList(propsList);
		// spec
		List<Fd> listFd = vo.getForm4();
		SKu sku = new SKu();
		List<SkuValues> listValues = new ArrayList<SkuValues>();
		for (int i = 0; i < listFd.size(); i++) {
			Fd fd = listFd.get(i);
			SkuValues v = ConvertUtil.convert(fd, SkuValues.class);
			listValues.add(v);
		}
		sku.setValues(listValues);
		List<Fc> listFc = vo.getForm6();
		List<SKuProps> listProps = new ArrayList<SKuProps>();
		for (int i = 0; i < listFc.size(); i++) {
			Fc fc = listFc.get(i);
			SKuProps sp = new SKuProps();
			sp.setId(fc.getId());
			sp.setValues(fc.getArry());
			listProps.add(sp);
		}
		sku.setList(listProps);
		productVo.setSku(sku);
		productVo.setDetail(vo.getForm5());
		
		return productService.addProduct(productVo);
	}

}
