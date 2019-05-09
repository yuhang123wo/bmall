package cn.yh.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-04-11
 */
@TableName("user_role")
@ApiModel(value = "UserRole对象", description = "")
public class UserRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long roleId;

	private Long userId;

	public UserRole() {
		super();
	}

	public UserRole(Long roleId, Long userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
