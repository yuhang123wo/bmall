/**
 * 
 */
package cn.yh.vo.user;

import cn.yh.pojo.eumn.State;
import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;
import cn.yh.vo.BasePage;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年5月8日
 * @desc
 */
public class QueryMuserVO extends BasePage{

	@SearchFieldAnnotation(column = "user_name", type = SearchType.like)
	private String userName;

	@ApiModelProperty("开始时间(YYYY-MM-DD)")
	@SearchFieldAnnotation(column = "create_time", type = SearchType.ge)
	private String startTime;

	@ApiModelProperty("结束时间(YYYY-MM-DD)")
	@SearchFieldAnnotation(column = "create_time", type = SearchType.le)
	private String endTime;

	@SearchFieldAnnotation(column = "state", type = SearchType.eq)
	private State state;

	@SearchFieldAnnotation(column = "mobile", type = SearchType.like)
	private String mobile;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
