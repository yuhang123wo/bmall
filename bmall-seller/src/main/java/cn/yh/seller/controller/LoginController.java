/**
 * 
 */
package cn.yh.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuhang
 * @date 2019年4月18日
 * @desc
 */
@Controller
public class LoginController {

	/**
	 * 登录接口
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	/**
	 * 不调logout方法则不会退出
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
 
}
