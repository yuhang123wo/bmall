/**
 * 
 */
package cn.yh.st.merchant.util;

import org.apache.shiro.SecurityUtils;

import cn.yh.st.config.shiro.ShiroUser;

/**
 * @author yuhang
 * @date 2019年7月9日
 * @desc
 */
public class UserUtil {

	public static ShiroUser getUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}
}
