/**
 * 
 */
package cn.yh.st.back.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.eumn.UserState;
import cn.yh.pojo.user.MRole;
import cn.yh.st.back.service.MUserService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.MUserVo;
import cn.yh.vo.user.AddMuserVo;
import cn.yh.vo.user.AddRoleVo;
import cn.yh.vo.user.QueryMuserVO;
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
	public String user(Model model) {
		return "admin/user-list";
	}

	@GetMapping("userList")
	@ResponseBody
	public ApiResponseEnity<?> userList(QueryMuserVO vo) {
		return mUserService.queryMuser(vo);
	}

	@GetMapping("addRoleView/{roleId}")
	public String addRoleView(Model model, @PathVariable("roleId") Long roleId) {
		model.addAttribute("authList", mUserService.getAllAuth(roleId));
		if (roleId != null) {
			MRole m = mUserService.getRoleById(roleId);
			if (null != m) {
				model.addAttribute("roleId", m.getId());
				model.addAttribute("roleName", m.getRoleName());
				model.addAttribute("remark", m.getRemark());
				model.addAttribute("state", m.getState().toString());
			}
		}
		return "admin/add-role";
	}

	@RequestMapping("addRole")
	@ResponseBody
	public ApiResponseEnity<Boolean> addRole(AddRoleVo vo) {
		if (StringUtils.isBlank(vo.getList())) {
			return new ApiResponseEnity<Boolean>().fail("请选择权限");
		}
		return mUserService.editRole(vo);
	}

	/**
	 * 修改角色状态
	 * 
	 * @param roleId
	 * @param state
	 * @return
	 */
	@PostMapping("updateRoleState")
	@ResponseBody
	public ApiResponseEnity<Boolean> updateRoleState(Long roleId, State state) {
		return mUserService.updateRoleState(roleId, state);
	}

	/**
	 * 
	 * @param userId
	 * @param state
	 * @return
	 */
	@PostMapping("updateUserState")
	@ResponseBody
	public ApiResponseEnity<Boolean> updateUserState(Long userId, UserState state) {
		return mUserService.updateUserState(userId, state);
	}

	/**
	 * 
	 * @param model
	 * @param userId
	 * @return
	 */
	@GetMapping("editUser/{userId}")
	public String editUser(Model model, @PathVariable("userId") Long userId) {
		List<MRole> list = mUserService.listRole(new RoleVo());
		if (null != userId && userId > 0) {
			ApiResponseEnity<MUserVo> user = mUserService.findMUserByUserId(userId);
			MRole m = mUserService.getRoleByUserId(userId);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId().floatValue() == m.getId()) {
					list.get(i).setCheck(true);
				}
			}
			model.addAllAttributes(JSON.parseObject(JSON.toJSONString(user.getData()), Map.class));
		}
		model.addAttribute("lisRole", list);
		return "admin/edit-user";
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addOrderUpdateUser")
	@ResponseBody
	public ApiResponseEnity<?> editUser(AddMuserVo vo) {
		return mUserService.editMUser(vo);
	}

}
