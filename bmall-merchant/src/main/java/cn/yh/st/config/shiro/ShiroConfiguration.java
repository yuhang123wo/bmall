package cn.yh.st.config.shiro;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.yh.st.fegin.service.UserService;

/**
 * 
 * @author yh
 * @Date 2017年10月18日
 * @desc shiro 配置
 */
@Configuration
public class ShiroConfiguration {

	@Autowired
	private UserService userService;

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager manager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		// 配置登录的url和登录成功的url
		bean.setLoginUrl("/login");
		bean.setSuccessUrl("/index");
//		Map<String, Filter> filters = bean.getFilters();
//		filters.put("loginAuth", new FormAuthenticationCaptchaFilter());
//		bean.setFilters(filters);
		bean.setSecurityManager(manager);

		// 配置访问权限
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/login", "authc");// 表示需要认证才可以访问
		filterChainDefinitionMap.put("/logout", "logout");
//		List<Auth> list = userinfoService.findAuthAll();
//		if (CollectionUtils.isNotEmpty(list)) {
//			for (Auth auth : list) {
//				System.out.println(auth.getAuthUrl());
//				filterChainDefinitionMap.put(auth.getAuthUrl(), "perms[" + auth.getAuthUrl() + "]");
//			}
//		}
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		filterChainDefinitionMap.put("/**", "authc");// 表示需要认证才可以访问
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		// 未授权界面;
		bean.setUnauthorizedUrl("/unauth");
		return bean;
	}

	// 配置核心安全事务管理器
	@Bean(name = "securityManager")
	public SecurityManager securityManager(@Qualifier("shiroDbRealm") ShiroDbRealm shiroDbRealm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(shiroDbRealm);
		return manager;
	}

	// 配置自定义的权限登录器
	@Bean(name = "shiroDbRealm")
	public ShiroDbRealm authRealm() {
		ShiroDbRealm authRealm = new ShiroDbRealm();
		authRealm.setCredentialsMatcher(new CustomCredentialsMatcher());
		return authRealm;
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			@Qualifier("securityManager") SecurityManager manager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		return advisor;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}
