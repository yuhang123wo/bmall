/**
 * 
 */
package cn.yh.vo;

import cn.yh.pojo.user.User;
import cn.yh.pojo.user.UserMeta;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年3月29日
 * @desc
 */
public class UserAllVo extends User {

	@ApiModelProperty("用户详细信息")
	private UserMeta meta;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.pojo.user.User#getPwd()
	 */
	@Override
	public String getPwd() {
		return null;
	}

	public UserMeta getMeta() {
		return meta;
	}

	public void setMeta(UserMeta meta) {
		this.meta = meta;
	}

}
