package cn.yh.product.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.api.CodeEnum;
import cn.yh.st.common.exception.DefaultException;

/**
 * 
 * @author yuhang
 * @Date 2018年12月25日
 * @desc
 */
@ControllerAdvice
public class ProductExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ApiResponseEnity<?> javaExceptionHandler(Exception ex) {
		if (ex instanceof DefaultException) {
			logger.error("接口处理异常", ex);
			return new ApiResponseEnity<>(CodeEnum.DEAL_ERROR);
		} else if (ex instanceof BindException) {

			BindException gm = (BindException) ex;
			String message = gm.getFieldErrors().get(0).getDefaultMessage();
			printData("参数验证失败", message);
			return new ApiResponseEnity<>(CodeEnum.PARAMS_ERROR);
		} else if (ex instanceof MethodArgumentNotValidException) {
			String message = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().get(0)
					.getDefaultMessage();
			printData("参数验证失败", message);
			return new ApiResponseEnity<>(CodeEnum.PARAMS_ERROR);
		} else {
			logger.error("未知异常", ex);
			return new ApiResponseEnity<>(CodeEnum.UNKOWN_ERROR);
		}
	}

	/**
	 * 
	 * @param title
	 * @param message
	 */
	private void printData(String title, String message) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String queryString = request.getQueryString();
		logger.info("{},{},请求, url: {}, method: {}, params: {}", title, message, url, method, queryString);

	}
}
