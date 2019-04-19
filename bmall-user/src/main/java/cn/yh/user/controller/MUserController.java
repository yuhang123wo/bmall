/**
 * 
 */
package cn.yh.user.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.user.MUser;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.user.service.IMUserService;

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

	/**
	 * 根据用户名查询
	 * 
	 * @param userName
	 * @return
	 */
	@GetMapping("findMUserByUserName")
	public ApiResponseEnity<MUser> findMUserByUserName(@Valid @NotNull String userName) {
		MUser muser = mUserService.getOne(new QueryWrapper<MUser>().eq("user_name", userName));
		return new ApiResponseEnity<MUser>(muser);
	}

	/**
	 * 根据ID查询
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("findMUserByUserId")
	public ApiResponseEnity<MUser> findMUserByUserId(@Valid @NotNull Long userId) {
		MUser muser = mUserService.getById(userId);
		return new ApiResponseEnity<MUser>(muser);
	}
}
