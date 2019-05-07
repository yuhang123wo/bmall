/**
 * 
 */
package cn.yh.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.user.MAuth;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.user.service.IAuthService;
import cn.yh.user.util.ZnodesUtil;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.user.AddRoleVo;
import cn.yh.vo.user.MAuthNodes;
import cn.yh.vo.user.Znodes;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private IAuthService authService;

	/**
	 * 取所有权限，并组装成treeNodes
	 * 
	 * @return
	 */
	@PostMapping("getAllAuth")
	public List<Znodes> getAllAuth(Long roleId) {
		if (roleId == null || roleId == 0) {
			List<MAuth> list = authService.list(new QueryWrapper<MAuth>().eq("state", State.ENABLE));
			List<MAuthNodes> result = ConvertUtil.convert(list, MAuthNodes.class);
			return ZnodesUtil.createZnodes(result, new ArrayList<Long>());
		} else {
			List<MAuth> list = authService.getAuthsByRoleId(roleId);
			List<MAuthNodes> result = ConvertUtil.convert(list, MAuthNodes.class);
			return ZnodesUtil.createZnodes(result, new ArrayList<Long>());
		}
	}

	/**
	 * 新增或修改角色权限
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("editRole")
	public ApiResponseEnity<Boolean> editRole(@Validated @RequestBody AddRoleVo vo) {
		authService.addEditRoleAndAuth(vo);
		return new ApiResponseEnity<Boolean>();
	}

}
