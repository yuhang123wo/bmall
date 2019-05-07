package cn.yh.user.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author yh
 * @Date 2017年10月17日
 * @desc controller日志
 */
@Aspect
@Configuration
public class LoggerControllerAdvice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 用@Pointcut来注解一个切入方法
	// @Pointcut注解 声明这是一个需要拦截的切面，也就是说，当调用任何一个controller方法的时候，都会激活这个aop
	@Pointcut("execution(* cn.yh.user.controller..*.*(..))") // 两个..代表所有子目录，最后括号里的两个..代表所有参数
	public void excudeService() {
	}

	// @Around注解 环绕执行，就是在调用之前和调用之后，都会执行一定的逻辑
	@Around("excudeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		try {
			Object[] args = pjp.getArgs();
			for (int i = 0; i < args.length; i++) {
				String json = args[i]==null?"":JSON.toJSONString(args[i]);
				logger.info("请求, url: {}, method: {}, params: {}", url, method, json);
			}
		} catch (Exception e) {
			logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
		}
		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		// logger.info("请求结束，controller的返回值是 " + result.toString());
		// logger.info("请求结束，controller的返回值是 " + result);
		return result;
	}
}
