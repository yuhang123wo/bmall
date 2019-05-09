/**
 * 
 */
package cn.yh.vo.user;

import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.State;
import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年4月29日
 * @desc
 */
@ApiModel
public class AddRoleVo {
	@ApiModelProperty("角色名")
	@SearchFieldAnnotation(column = "role_name", type = SearchType.eq)
	@NotNull(message = "角色名不能为空")
	private String roleName;
	@ApiModelProperty("状态")
	private State state;
	@ApiModelProperty("备注")
	private String remark;

	private String list;

	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
