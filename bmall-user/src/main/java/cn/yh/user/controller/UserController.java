package cn.yh.user.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yh.pojo.user.User;
import cn.yh.pojo.user.UserMeta;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.user.service.IUserMetaService;
import cn.yh.user.service.IUserService;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.UserAllVo;
import cn.yh.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("user")
@Api(tags = "用户相关接口")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserMetaService userMetaService;
	@Autowired
	private Validator globalValidator;

	/**
	 * 取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("getUserBaseInfoById")
	@ApiOperation("取用户基本信息")
	public ApiResponseEnity<UserVo> getUserBaseInfoById(@Validated UserIn in, BindingResult result) {
		User user = userService.getById(in.getUserId());
		if (user == null) {
			return new ApiResponseEnity<UserVo>().fail("用户不存在");
		}

		UserVo vo = ConvertUtil.convert(user, UserVo.class);
		return new ApiResponseEnity<UserVo>(vo);
	}

	/**
	 * 取用户所信息，包括user,usermeta
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("getUserAllInfoById")
	@ApiOperation("取用户信息")
	public ApiResponseEnity<UserAllVo> getUserAllInfoById(Long userId) {
		User user = userService.getById(userId);
		if (user == null) {
			return new ApiResponseEnity<UserAllVo>().fail("用户不存在");
		}
		UserAllVo vo = ConvertUtil.convert(user, UserAllVo.class);
		UserMeta meta = userMetaService.getById(user.getId());
		vo.setMeta(meta);
		return new ApiResponseEnity<UserAllVo>(vo);
	}

}
