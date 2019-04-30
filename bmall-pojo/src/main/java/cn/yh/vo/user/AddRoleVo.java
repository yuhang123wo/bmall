/**
 * 
 */
package cn.yh.vo.user;

import javax.validation.constraints.NotNull;

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
	@ApiModelProperty("状态(1:有效,0:无效)")
	private Integer state;
	@ApiModelProperty("备注")
	private String remark;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
