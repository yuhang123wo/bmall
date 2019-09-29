/**
 * 
 */
package cn.yh.st.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuhang
 * @date 2019年9月29日
 * @desc
 */
@Controller
public class IndexController {

	@RequestMapping("login")
	public String toIndex() {
		return "home/home";
	}
}
