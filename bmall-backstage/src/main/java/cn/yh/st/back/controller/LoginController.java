/**
 * 
 */
package cn.yh.st.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuhang
 * @date 2019年4月18日
 * @desc
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		System.out.println(1);
		return "login";
	}

	@RequestMapping("index")
	public String index() {
		return "index";}
}
