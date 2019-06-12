package cn.yh.st.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONArray;

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
	@Pointcut("execution(* cn.yh.st.merchant.controller..*.*(..))") // 两个..代表所有子目录，最后括号里的两个..代表所有参数
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
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < args.length; i++) {
				if (!(args[i] instanceof HttpServletRequest) && !(args[i] instanceof HttpServletResponse)) {
					if (args[i] != null) {
						list.add(args[i]);
					}
				}
			}
			logger.info("请求, url: {}, method: {}, params: {}", url, method, JSONArray.toJSONString(list));
		} catch (Exception e) {
			logger.error("excudeService", e);
			logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
		}
		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		// logger.info("请求结束，controller的返回值是 " + result.toString());
		logger.info("请求结束，controller的返回值是 " + result);
		return result;
	}
}
