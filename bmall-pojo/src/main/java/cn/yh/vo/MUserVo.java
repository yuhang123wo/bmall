/**
 * 
 */
package cn.yh.vo;

import java.util.List;

import cn.yh.pojo.user.MAuth;
import cn.yh.pojo.user.MRole;
import cn.yh.pojo.user.MUser;

/**
 * @author yuhang
 * @date 2019年4月26日
 * @desc
 */
public class MUserVo extends MUser {

	private List<MRole> roles;

	private List<MAuth> auths;

	public List<MRole> getRoles() {
		return roles;
	}

	public void setRoles(List<MRole> roles) {
		this.roles = roles;
	}

	public List<MAuth> getAuths() {
		return auths;
	}

	public void setAuths(List<MAuth> auths) {
		this.auths = auths;
	}

}
