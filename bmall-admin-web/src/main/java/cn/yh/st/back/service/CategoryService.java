/**
 * 
 */
package cn.yh.st.back.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Category;
import cn.yh.st.common.api.ApiResponseEnity;

/**
 * @author yuhang
 * @date 2019年5月21日
 * @desc
 */
@FeignClient(value = "service-product")
public interface CategoryService {
	@GetMapping("category/listCategory")
	ApiResponseEnity<List<Category>> listCategory(@RequestParam("state")State state);
	
	@GetMapping("category/addOrderCategory")
	ApiResponseEnity<Boolean> addOrderCategory(@RequestBody Category category);
}
