/**
 * 
 */
package cn.yh.st.back.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
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

	@RequestMapping("logout")
	public String logout() {
		return "login";
	}
}
