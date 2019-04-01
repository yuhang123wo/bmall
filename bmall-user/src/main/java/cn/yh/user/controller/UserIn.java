/**
 * 
 */
package cn.yh.user.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yuhang
 * @date 2019年3月29日
 * @desc
 */
public class UserIn {

	@NotNull(message = "用户缺失")
	@Min(value = 1, message = "用户ID最小值为1")
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
