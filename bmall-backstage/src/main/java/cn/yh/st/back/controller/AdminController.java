/**
 * 
 */
package cn.yh.st.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuhang
 * @date 2019年4月26日
 * @desc 管理员管理
 */
@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping("role")
	public String role(Model model) {
		return "admin/role-list";
	}
	
	
	@GetMapping("user")
	public String userList(Model model) {
		return "admin/user-list";
	}
}
