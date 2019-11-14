/**
 * 
 */
package cn.yh.product.base;

import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.api.CodeEnum;
import cn.yh.st.common.api.CommonResult;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public class BaseController {

	/**
	 * 
	 * @param result
	 * @return
	 */
	public ApiResponseEnity<?> getReturnData(CommonResult result) {
		if (result == null) {
			return new ApiResponseEnity<>();
		}
		if (result.isSuccess()) {
			return new ApiResponseEnity<>(result.getData());
		} else {
			return new ApiResponseEnity<>(CodeEnum.DEAL_ERROR.getCode(), result.getMsg());
		}
	}
}
