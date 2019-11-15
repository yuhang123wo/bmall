/**
 * 
 */
package cn.yh.st.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.back.service.ProductService;
import cn.yh.st.common.Message;
import cn.yh.vo.product.QueryAttrVo;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 属性列表
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("attr/queryAttr")
	@ResponseBody
	public Message queryAttr(@RequestBody QueryAttrVo vo) {
		return new Message(productService.listAttr(vo));
	}
}
