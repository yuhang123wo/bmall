/**
 * 
 */
package cn.yh.user.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.user.MRole;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.user.service.IMRoleService;
import cn.yh.user.service.IMUserService;
import cn.yh.vo.user.RoleVo;

/**
 * @author yuhang
 * @date 2019年4月29日
 * @desc
 */
@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private IMRoleService mRoleService;
	@Autowired
	private IMUserService mUserService;

	/**
	 * 按条件搜索所有角色
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listRole")
	public List<MRole> listRole(@RequestBody @Validated RoleVo vo) {
		QueryWrapper<MRole> queryWrapper = SearchToQuery.getQuery(vo);
		queryWrapper.orderByDesc("id");
		return mRoleService.list(queryWrapper);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateRoleState")
	public ApiResponseEnity<Boolean> updateRoleState(Long roleId, State state) {
		MRole m = mRoleService.getById(roleId);
		if (m == null) {
			return new ApiResponseEnity<Boolean>().fail("角色不存在");
		}
		m.setState(state);
		m.setUpdateTime(new Date());
		boolean flag = mRoleService.updateById(m);
		if (flag) {
			return new ApiResponseEnity<Boolean>();
		}
		return new ApiResponseEnity<Boolean>().fail("修改失败");
	}

	/**
	 * 
	 * @param roleId
	 * @return
	 */
	@PostMapping(value = "getRoleById")
	public MRole getRoleById(@RequestParam("roleId") Long roleId) {
		return mRoleService.getById(roleId);
	}

	/**
	 *一个用户只有一个角色（此处之前写完了，难得改）
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "getRoleByUserId")
	public MRole getRoleByUserId(@RequestParam("userId") Long userId) {
		List<MRole> list = mUserService.getRolesByUserId(userId);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
