package cn.yh.zuul.config;

import java.io.InputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.ServletInputStreamWrapper;

import cn.yh.st.common.util.AesEncryptUtils;

/**
 * 参数解密过滤器 ，用于将body中的参数进行解密并传递到后端
 * 
 * @author lz
 *
 */
@Component
public class BodyDecryptFilter extends ZuulFilter {

	private Logger log = LoggerFactory.getLogger(BodyDecryptFilter.class);

	/**
	 * 解密key
	 */
	@Value("${gateway.encryption.key}")
	private String key;

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		try {

			// 如果是请求content-Type 是文件上传则不对请求做解密处理
			String contentType = ctx.getRequest().getContentType();
			if (StringUtils.isNotBlank(contentType) && contentType.contains(MediaType.MULTIPART_FORM_DATA_VALUE)) {
				return null;
			}
			InputStream in = (InputStream) ctx.get("requestEntity");
			if (in == null) {
				in = ctx.getRequest().getInputStream();
			}
			String body = StreamUtils.copyToString(in, Consts.UTF_8);
			if (StringUtils.isBlank(body)) {
				// 如果body为空 则不做解密操作
				return null;
			}
			body = AesEncryptUtils.decrypt(body, key);
			// 如果解密内容为null 表示解密过程出现异常
			if (null == body) {
				throw new Exception();
			}
			byte[] bytes = body.getBytes(Consts.UTF_8);
			ctx.setRequest(new HttpServletRequestWrapper(ctx.getRequest()) {
				@Override
				public ServletInputStream getInputStream() {
					return new ServletInputStreamWrapper(bytes);
				}

				@Override
				public int getContentLength() {
					return bytes.length;
				}

				@Override
				public long getContentLengthLong() {
					return bytes.length;
				}
			});
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ctx.addZuulResponseHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			String responseBody = String
					.format("{\"code\":\"401\",\"message\":\"%s\",\"data\":\"\",\"subMessages\":[]}", "数据解密失败");
			ctx.setResponseBody(encryptionResponseBody(responseBody));
			return null;
		}
		return null;
	}

	/**
	 * api网关异常返回加密
	 * 
	 * @param responseBody
	 * @return
	 * @throws Exception
	 */
	private String encryptionResponseBody(String responseBody) {
		String body = null;
		try {
			body = AesEncryptUtils.encrypt(responseBody, key);
		} catch (Exception e) {
			log.error("encryptionResponseBody", e);
		}
		if (null == body) {
			log.warn("encryptionResponseBody---encrypt fail. responseBody={}", responseBody);
			return responseBody;
		}
		return body;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		// Filter 过滤优先级 1 。IPFilter -->2 授权Filter -->3 BodyDecryptFilter 解密过滤器
		return 2;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
