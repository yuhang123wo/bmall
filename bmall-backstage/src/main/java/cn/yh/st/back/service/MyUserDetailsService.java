package cn.yh.st.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import cn.yh.pojo.user.MUser;
import cn.yh.st.common.api.ApiResponseEnity;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private MUserService mUserService;

	/**
	 * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
	 */

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		ApiResponseEnity<MUser> sysUser = mUserService.findMUserByUserName(userName);
		if (null == sysUser || null == sysUser.getData()) {
			throw new UsernameNotFoundException(userName);
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		return new User(sysUser.getData().getUserName(), sysUser.getData().getPwd(), authorities);
	}
}
