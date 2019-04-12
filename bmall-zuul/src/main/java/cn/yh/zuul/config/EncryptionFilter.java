/**
 * 
 */
package cn.yh.zuul.config;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.ServletInputStreamWrapper;

import cn.yh.st.common.util.AesEncryptUtils;

/**
 * @author yuhang
 * @date 2019年4月12日
 * @desc （1）方法说明
 * 
 *       filterType : filter类型,分为pre、error、post、 route
 * 
 *       filterOrder: filter执行顺序，通过数字指定，数字越小，执行顺序越先
 * 
 *       shouldFilter: filter是否需要执行 true执行 false 不执行
 * 
 *       run : filter具体逻辑（上面为true那么这里就是具体执行逻辑）
 * 
 *       （2）filter类型说明
 * 
 *       pre: 请求执行之前filter
 * 
 *       route: 处理请求，进行路由
 * 
 *       post: 请求处理完成后执行的filter
 * 
 *       error: 出现错误时执行的filter
 */
@Component
public class EncryptionFilter extends ZuulFilter {

	private Logger log = LoggerFactory.getLogger(EncryptionFilter.class);
	/**
	 * 加密key
	 */
	@Value("${gateway.encryption.key}")
	private String key;

	@Value("${authorization.access.callback.prefix}")
	private String prefix;
	/**
	 * 跳过RPC请求调用的加密
	 */
	private static final String SKIP_URL = "/rpc/";

	/**
	 * 网关跳过swagger验证固定验证标识
	 */
	final static String GATEWAY_SWAGGER_TAG = "b55c2a150516318b2a73cf96131d4908e83e63ac4933694c";

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		try {
			HttpServletRequest request = ctx.getRequest();
			if (isIgnoreSwaggerReq(request) || isIgnoreRpcReq(request) || isIgnoreCallBackReq(request)) {
				return null;
			}

			InputStream data = ctx.getResponseDataStream();
			if (null != data) {
				String body = StreamUtils.copyToString(data, Consts.UTF_8);
				body = AesEncryptUtils.encrypt(body, key);
				byte[] bytes = body.getBytes(Consts.UTF_8);
				ctx.setResponseDataStream(new ServletInputStreamWrapper(bytes));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 回调URL不做加密
	 * 
	 * @param request
	 * @return
	 */
	private boolean isIgnoreCallBackReq(HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		if (requestUrl.contains(prefix)) {
			return true;
		}
		return false;
	}

	/**
	 * 如果是rpc调用跳过解密
	 * 
	 * @param request
	 * @return
	 */
	private boolean isIgnoreRpcReq(HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		if (StringUtils.isNotBlank(requestUrl) && requestUrl.contains(SKIP_URL)) {
			return true;
		}
		return false;
	}

	/**
	 * swagger不做处理
	 * 
	 * @param request
	 * @return
	 */
	private boolean isIgnoreSwaggerReq(HttpServletRequest request) {
		String swaggerHeader = request.getHeader("swagger");
		if (StringUtils.isNotBlank(swaggerHeader) && swaggerHeader.contains(GATEWAY_SWAGGER_TAG)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 3;
	}

	@Override
	public String filterType() {
		return "post";
	}
}
