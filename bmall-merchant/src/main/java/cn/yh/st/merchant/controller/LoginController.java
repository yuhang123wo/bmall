/**
 * 
 */
package cn.yh.st.merchant.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author yuhang
 * @date 2019年6月11日
 * @desc
 */
@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/login")
	public String loginPost(HttpServletRequest request, String username, String password, String captcha)
			throws Exception {
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
				token.setRememberMe(true);
				subject.login(token);
				return "index";
			} catch (Exception e) {
				logger.error("登录异常", e);

			}
			return "login";

		}
		return "index";
	}

	@GetMapping("/login")
	public String loginGet() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			return "login";

		}
		return "index";
	}

	@GetMapping("/index")
	public String index() throws Exception {
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes redirectAttributes) {
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		return "redirect:/login";
	}
}
