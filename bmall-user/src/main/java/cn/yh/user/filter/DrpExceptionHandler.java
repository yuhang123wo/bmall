package cn.yh.user.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.exception.DefaultException;

/**
 * 
 * @author yuhang
 * @Date 2018年12月25日
 * @desc
 */
@ControllerAdvice
public class DrpExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ApiResponseEnity<?> javaExceptionHandler(Exception ex) {
		logger.error("接口异常", ex);
		if (ex instanceof DefaultException) {
			return new ApiResponseEnity<>().fail(ex.getMessage());
		}
		if (ex instanceof BindException) {
			BindException gm = (BindException) ex;
			return new ApiResponseEnity<>().fail(gm.getFieldErrors().get(0).getDefaultMessage());
		}
		if (ex instanceof MethodArgumentNotValidException) {
			return new ApiResponseEnity<>().fail(((MethodArgumentNotValidException) ex).getBindingResult()
					.getAllErrors().get(0).getDefaultMessage());
		}
		return new ApiResponseEnity<>().fail("系统异常");
	}
}
