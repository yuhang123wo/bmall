/**
 * 
 */
package cn.yh.st.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Attr;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.vo.product.QueryAttrVo;

/**
 * @author yuhang
 * @date 2019年7月3日
 * @desc
 */
@Controller
@RequestMapping("attr")
public class SellerAttrController {

	@Autowired
	private ProductService productService;

	@GetMapping("listView")
	public String productView() {
		return "product/attr-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Attr>> listAttr(QueryAttrVo vo) {
		return productService.listAttr(vo);
	}
}
