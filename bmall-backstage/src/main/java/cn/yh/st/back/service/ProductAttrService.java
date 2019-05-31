/**
 * 
 */
package cn.yh.st.back.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.ProductAttr;
import cn.yh.pojo.product.ProductAttrValue;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.BasePage;
import cn.yh.vo.product.ProductAttrVo;

/**
 * @author yuhang
 * @date 2019年5月30日
 * @desc
 */
@FeignClient(value = "service-product")
public interface ProductAttrService {

	@GetMapping("attr/listAttr")
	ApiResponseEnity<Page<ProductAttr>> listAttr(@RequestParam BasePage vo);

	@GetMapping("attr/listAttrValue")
	ApiResponseEnity<List<ProductAttrValue>> listAttrValue(Long attrId);

	@PostMapping("attr/addProductAttrAndValue")
	ApiResponseEnity<?> addProductAttrAndValue(@RequestBody ProductAttrVo vo);
}
