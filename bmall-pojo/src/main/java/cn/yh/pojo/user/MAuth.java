package cn.yh.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.State;
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
 * @since 2019-04-11
 */
@TableName("m_auth")
@ApiModel(value = "MAuth对象", description = "")
public class MAuth extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "权限名")
	private String authName;

	@ApiModelProperty(value = "说明")
	private String remark;

	@ApiModelProperty(value = "状态(0:禁用,1:可用)")
	private State state;

	private Date updateTime;
	
	@ApiModelProperty(value="父ID")
	private Long pId;

	
	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
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

}
