/**
 * 
 */
package cn.yh.st.fegin.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.Product;
import cn.yh.pojo.product.Props;
import cn.yh.pojo.product.Spec;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.product.AddAttrValueVo;
import cn.yh.vo.product.AddAttrVo;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.AddSpecVo;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.QueryCategoryVo;
import cn.yh.vo.product.QueryProductVo;
import cn.yh.vo.product.QuerySpecVo;
import cn.yh.vo.product.UpdateStateVo;

/**
 * @author yuhang
 * @date 2019年5月21日
 * @desc
 */
@FeignClient(value = "service-product")
public interface ProductService {

	@PostMapping("product/listProduct")
	public ApiResponseEnity<Page<Product>> listProduct(@RequestBody QueryProductVo vo);

	@PostMapping("product/addProduct")
	public ApiResponseEnity<Boolean> addProduct(@RequestBody AddProductVo vo);

	@PostMapping("category/listCategory")
	public ApiResponseEnity<List<Category>> listCategory(@RequestBody QueryCategoryVo vo);
	
	@GetMapping("category/getCategoryById")
	public ApiResponseEnity<Category> getCategoryById(@RequestParam("categoryId") Long categoryId);
	
	
	@PostMapping("category/addCategory")
	public ApiResponseEnity<?> addCategory(@RequestBody Category vo);
	
	
	@PostMapping("category/updateCategoryState")
	public ApiResponseEnity<?> updateCategoryState(@RequestParam Long categoryId, @RequestParam State state);


	@PostMapping("props/listProps")
	public ApiResponseEnity<Page<Props>> listProps(@RequestBody QueryAttrVo vo);
	
	@PostMapping("props/addProps")
	public ApiResponseEnity<?> adddProps(@RequestBody Props props);
	
	@PostMapping("props/updateProps")
	public ApiResponseEnity<?> updateProps(@RequestBody Props props);
	
	@PostMapping("attr/listAttr")
	public ApiResponseEnity<Page<Attr>> listAttr(@RequestBody QueryAttrVo vo);
	
	@GetMapping("attr/listAttrValue")
	public ApiResponseEnity<?> listAttrValue(@RequestParam String attrIds, @RequestParam State state);
	
	@PostMapping("addAttrAndValue")
	public ApiResponseEnity<?> addAttrAndValue(@RequestBody AddAttrVo vo);
	
	@PostMapping("attr/updateAttrState")
	public ApiResponseEnity<?> updateAttrState(@RequestBody UpdateStateVo vo);
	
	@PostMapping("attr/updateAttrValueState")
	public ApiResponseEnity<?> updateAttrValueState(@RequestBody UpdateStateVo vo);
	
	@PostMapping("attr/addAttrValue")
	public ApiResponseEnity<?> addAttrValue(@RequestBody AddAttrValueVo vo);
	
	@PostMapping("spec/listSpec")
	public ApiResponseEnity<Page<Spec>> listSpec(@RequestBody QuerySpecVo vo);
	
	@GetMapping("spec/listSpecValue")
	public ApiResponseEnity<?> listSpecValue(@RequestParam String specIds, @RequestParam State state);

	@PostMapping("spec/addSpecAndValue")
	public ApiResponseEnity<?> addSpecAndValue(@RequestBody AddSpecVo vo);
	
	@PostMapping("spec/updateSpecState")
	public ApiResponseEnity<?> updateSpecState(@RequestBody UpdateStateVo vo);
	
	@PostMapping("spec/updateSpecValueState")
	public ApiResponseEnity<?> updateSpecValueState(@RequestBody UpdateStateVo vo);
	
	@PostMapping("spec/addSpecValue")
	public ApiResponseEnity<?> addSpecValue(@RequestBody AddAttrValueVo vo);
	
	
	@GetMapping("props/getPropsById")
	public ApiResponseEnity<Props> getPropsById(@RequestParam Long id);

}
