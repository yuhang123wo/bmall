/**
 * 
 */
package cn.yh.st.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yh.pojo.user.MRole;
import cn.yh.st.back.service.MUserService;
import cn.yh.vo.user.RoleVo;

/**
 * @author yuhang
 * @date 2019年4月26日
 * @desc 管理员管理
 */
@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private MUserService mUserService;

	/**
	 * 角色列表
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("role")
	public String role(Model model, RoleVo vo) {
		model.addAttribute("roleList", mUserService.listRole(vo));
		return "admin/role-list";
	}

	@GetMapping("user")
	public String userList(Model model) {
		return "admin/user-list";
	}
}
