/**
 * 
 */
package cn.yh.user.service;

import cn.yh.pojo.user.MRole;

/**
 * @author yuhang
 * @date 2019年4月11日
 * @desc 权限相关service
 */
public interface IAuthService {

	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 */
	int saveRole(MRole role);
}
