/**
 * 
 */
package cn.yh.st.back.config;

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
import cn.yh.st.back.service.MUserService;
import cn.yh.st.common.api.ApiResponseEnity;

/**
 * @author yuhang
 * @date 2019年4月18日
 * @desc
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

//	@Autowired
//	private MUserService userService;

	/**
	 * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		ApiResponseEnity<MUser> sysUser = userService.findMUserByUserName(username);
//		System.out.println(2);
//		if (sysUser.getData() == null) {
//			throw new UsernameNotFoundException(username);
//		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//		for (SysRole role : sysUser.getRoleList()) {
//			for (SysPermission permission : role.getPermissionList()) {
//				authorities.add(new SimpleGrantedAuthority(permission.getCode()));
//			}
//		}
		System.out.println(1111);
		return null;
//		return new User(username, sysUser.getData().getPwd(), authorities);
	}
}
