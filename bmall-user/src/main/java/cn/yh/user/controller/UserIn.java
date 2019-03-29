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

	@NotNull
	@Min(1)
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
