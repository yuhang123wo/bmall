package cn.yh.st.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.yh.st.common.util.MD5;

/**
 * 
 * @author yuhang
 * @Date 2017年6月30日
 * @desc
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object accountCredentials = getCredentials(info);
		try {
			return equals(MD5.md5Encode(String.valueOf(token.getPassword())), accountCredentials);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}