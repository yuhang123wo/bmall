package cn.yh.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yh.pojo.user.User;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.user.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("getUserInfoById")
	public ApiResponseEnity<User> getUserInfoById(Long userId) {
		return new ApiResponseEnity<User>(userService.getById(userId));
	}
}
