/**
 * 
 */
package cn.yh.vo.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.user.MRole;
import cn.yh.pojo.user.MUser;
import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;
import cn.yh.st.common.util.SearchToQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年4月29日
 * @desc
 */
@ApiModel
public class RoleVo {
	@ApiModelProperty("角色名")
	@SearchFieldAnnotation(column = "role_name", type = SearchType.like)
	private String roleName;

	@ApiModelProperty("开始时间(YYYY-MM-DD)")
	@SearchFieldAnnotation(column = "create_time", type = SearchType.ge)
	private String startTime;

	@ApiModelProperty("结束时间(YYYY-MM-DD)")
	@SearchFieldAnnotation(column = "create_time", type = SearchType.le)
	private String endTime;

	@ApiModelProperty("状态(1:有效,0:无效)")
	@SearchFieldAnnotation(column = "state", type = SearchType.eq)
	private Integer state;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
