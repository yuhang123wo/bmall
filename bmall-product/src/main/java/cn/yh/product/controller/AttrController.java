/**
 * 
 */
package cn.yh.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.ProductAttr;
import cn.yh.pojo.product.ProductAttrValue;
import cn.yh.product.service.IProductAttrService;
import cn.yh.product.service.IProductAttrValueService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.BasePage;
import cn.yh.vo.product.ProductAttrVo;

/**
 * @author yuhang
 * @date 2019年5月30日
 * @desc
 */
@RestController
@RequestMapping("attr")
public class AttrController {

	@Autowired
	private IProductAttrService productAttrService;
	@Autowired
	private IProductAttrValueService productAttrValueService;

	@GetMapping("listAttr")
	public ApiResponseEnity<Page<ProductAttr>> listAttr(BasePage vo) {
		Page<ProductAttr> page = new Page<ProductAttr>(vo.getPageNo(), vo.getPageSize());
		Page<ProductAttr> list = (Page<ProductAttr>) productAttrService.page(page);
		return new ApiResponseEnity<Page<ProductAttr>>(list);
	}

	@GetMapping("listAttrValue")
	public ApiResponseEnity<List<ProductAttrValue>> listAttrValue(Long attrId) {
		return new ApiResponseEnity<List<ProductAttrValue>>(
				productAttrValueService.list(new QueryWrapper<ProductAttrValue>().eq("attr_id", attrId)));
	}

	@PostMapping("addProductAttrAndValue")
	public ApiResponseEnity<?> addProductAttrAndValue(@RequestBody ProductAttrVo vo) {
		productAttrService.saveOrderUpdateAttrAndValue(vo);
		return new ApiResponseEnity<>();
	}

}
