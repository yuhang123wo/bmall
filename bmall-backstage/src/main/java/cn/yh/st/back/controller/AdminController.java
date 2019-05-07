/**
 * 
 */
package cn.yh.st.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.pojo.user.MRole;
import cn.yh.st.back.service.MUserService;
import cn.yh.st.common.api.ApiResponseEnity;
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
	public String role() {
		return "admin/role-list";
	}

	@GetMapping("roleList")
	@ResponseBody
	public List<MRole> roleList(RoleVo vo) {
		return mUserService.listRole(vo);
	}

	
	
	@GetMapping("user")
	public String userList(Model model) {
		return "admin/user-list";
	}

	@GetMapping("addRoleView/{roleId}")
	public String addRoleView(Model model,@PathVariable("roleId")Long roleId) {
		model.addAttribute("authList", mUserService.getAllAuth(roleId) );
		return "admin/add-role";
	}
	
	@RequestMapping("addRole")
	@ResponseBody
	public ApiResponseEnity<String> addRole() {
		System.out.println(1);
		return new ApiResponseEnity<String>();
	}
}
