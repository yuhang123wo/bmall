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
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.QueryCategoryVo;
import cn.yh.vo.product.QueryProductVo;

/**
 * @author yuhang
 * @date 2019年5月21日
 * @desc
 */
@FeignClient(value = "service-product")
public interface ProductService {

	@PostMapping("product/listProduct")
	public ApiResponseEnity<Page<Product>> listProduct(@RequestBody QueryProductVo vo);

	@PostMapping("listAttr")
	public ApiResponseEnity<Page<Attr>> listAttr(@RequestBody QueryAttrVo vo);

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
}
