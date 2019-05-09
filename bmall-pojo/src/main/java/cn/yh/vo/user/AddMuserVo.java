/**
 * 
 */
package cn.yh.vo.user;

import javax.validation.constraints.NotBlank;

import cn.yh.pojo.eumn.UserState;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年5月8日
 * @desc
 */
public class AddMuserVo {
	@ApiModelProperty(value = "userId")
	private Long userId;

	@ApiModelProperty(value = "用户名")
	@NotBlank
	private String userName;

	@ApiModelProperty(value = "真实名")
	@NotBlank
	private String realName;

	@ApiModelProperty(value = "电话")
	@NotBlank
	private String mobile;

	@ApiModelProperty(value = "用户状态(0:禁用,1:可用,2:删除)")
	private UserState state;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "角色")
	@NotBlank
	private String roles;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
