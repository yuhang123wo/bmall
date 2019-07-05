/**
 * 
 */
package cn.yh.st.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuhang
 * @date 2019年7月3日
 * @desc
 */
@Controller
@RequestMapping("props")
public class SellerPropsController {

	@GetMapping("listView")
	public String productView() {
		return "product/props-list";
	}
}
