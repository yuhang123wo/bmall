/**
 * 
 */
package cn.yh.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.UserState;
import cn.yh.pojo.user.MAuth;
import cn.yh.pojo.user.MUser;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.user.service.IAuthService;
import cn.yh.user.service.IMUserService;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.MUserVo;
import cn.yh.vo.user.AddMuserVo;
import cn.yh.vo.user.QueryMuserVO;

/**
 * @author yuhang
 * @date 2019年4月18日
 * @desc 管理用户相关接口
 */
@RestController
@RequestMapping("sys/user")
public class MUserController {

	@Autowired
	private IMUserService mUserService;
	@Autowired
	private IAuthService authService;

	/**
	 * 根据用户名查询
	 * 
	 * @param userName
	 * @return
	 */
	@GetMapping("findMUserByUserName")
	public ApiResponseEnity<MUserVo> findMUserByUserName(@Valid @NotNull String userName) {
		MUser muser = mUserService.getOne(new QueryWrapper<MUser>().eq("user_name", userName));
		return new ApiResponseEnity<MUserVo>(getMUserVo(muser));
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	private MUserVo getMUserVo(MUser user) {
		if (user == null) {
			return null;
		}
		MUserVo vo = ConvertUtil.convert(user, MUserVo.class);
		vo.setRoles(mUserService.getRolesByUserId(user.getId()));
		List<MAuth> list = new ArrayList<MAuth>();
		if (null != vo.getRoles() && vo.getRoles().size() > 0) {
			for (int i = 0; i < vo.getRoles().size(); i++) {
				list.addAll(authService.getAuthsByRoleId(vo.getRoles().get(i).getId()));
			}

		}
		vo.setAuths(list);
		return vo;
	}

	/**
	 * 根据ID查询
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("findMUserByUserId")
	public ApiResponseEnity<MUserVo> findMUserByUserId(@Valid @NotNull Long userId) {
		MUser muser = mUserService.getById(userId);
		return new ApiResponseEnity<MUserVo>(getMUserVo(muser));
	}

	/**
	 * 添加后台管理用户
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("editMUser")
	public ApiResponseEnity<?> addMUser(@RequestBody @Validated AddMuserVo vo) {
		if (null != vo.getUserId() && vo.getUserId() > 0) {
			mUserService.updateMuserAndRole(vo);
		} else {
			mUserService.addMuserAndRole(vo);
		}
		return new ApiResponseEnity<>();
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("queryMuser")
	public ApiResponseEnity<Page<MUser>> queryMuser(@RequestBody QueryMuserVO vo) {
		Page<MUser> page = new Page<MUser>(vo.getPageNo(), vo.getPageSize());
		QueryWrapper<MUser> queryWrapper = SearchToQuery.getQuery(vo);
		queryWrapper.orderByDesc("id");
		return new ApiResponseEnity<Page<MUser>>((Page<MUser>) mUserService.page(page, queryWrapper));
	}
	
	/**
	 * 更新用户状态
	 * @param roleId
	 * @param state
	 * @return
	 */
	@PostMapping("updateUserState")
	public ApiResponseEnity<Boolean> updateUserState(Long roleId,UserState state) {
		MUser m = mUserService.getById(roleId);
		if (m == null) {
			return new ApiResponseEnity<Boolean>().fail("用户不存在");
		}
		m.setState(state);
		m.setUpdateTime(new Date());
		boolean flag = mUserService.updateById(m);
		if (flag) {
			return new ApiResponseEnity<Boolean>();
		}
		return new ApiResponseEnity<Boolean>().fail("修改失败");
	}

}
