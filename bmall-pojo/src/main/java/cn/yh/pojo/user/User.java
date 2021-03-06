package cn.yh.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.UserState;
import cn.yh.st.common.Entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-03-26
 */
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户名")
	private String userName;

	@ApiModelProperty(value = "真实名")
	private String realName;

	@ApiModelProperty(value = "联系电话")
	private String mobile;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "登录密码")
	private String pwd;

	@ApiModelProperty(value = "用户类型(1:采购,2:厂商)")
	private Integer userType;

	@ApiModelProperty(value = "用户状态(0:禁用,1:可用,2:删除)")
	private UserState state;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
