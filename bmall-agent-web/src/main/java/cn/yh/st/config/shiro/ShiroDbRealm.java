package cn.yh.st.config.shiro;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.st.common.util.MD5;
import cn.yh.st.fegin.service.UserService;
import cn.yh.vo.MUserVo;

public class ShiroDbRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		ShiroUser u = (ShiroUser) principals.getPrimaryPrincipal();
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		String exitCode = (String) SecurityUtils.getSubject().getSession().getAttribute("captchaTxt");
//		if (StringUtils.isBlank(captcha) || StringUtils.isBlank(exitCode) || !captcha.equalsIgnoreCase(exitCode)) {
//			throw new DefaultException("");
//		}
//		ApiResponseEnity<MUserVo> u = userService.findMUserByUserName(token.getUsername());
//		if (u == null) {
//			throw new DefaultException("");
//		}
		try {
//			MUserVo v = u.getData();
			AuthenticationInfo info = new SimpleAuthenticationInfo(
					new ShiroUser(1L,"yuhang", "gb"), "c4ca4238a0b923820dcc509a6f75849b", getName());
			System.out.println(info);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(MD5.md5Encode("1"));
	}
}
