/**
 * 
 */
package cn.yh.st.back.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Product;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.product.AddProductVo;
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

	@PostMapping("product/addProduct")
	public ApiResponseEnity<Boolean> addProduct(@RequestBody AddProductVo vo);
}
