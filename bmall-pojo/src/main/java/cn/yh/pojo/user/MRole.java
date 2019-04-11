package cn.yh.pojo.user;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.State;
import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-04-11
 */
@TableName("m_role")
@ApiModel(value = "MRole对象", description = "")
public class MRole extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色名")
	@NotBlank
	private String roleName;

	@ApiModelProperty(value = "说明")
	private String remark;

	@ApiModelProperty(value = "状态(0:禁用，1:启用)")
	private State state;

	private Date updateTime;

	private Date createTime;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
