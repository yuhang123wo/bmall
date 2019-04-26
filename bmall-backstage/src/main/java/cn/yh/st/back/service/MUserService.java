/**
 * 
 */
package cn.yh.st.back.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.MUserVo;

/**
 * @author yuhang
 * @date 2019年4月19日
 * @desc
 */
@FeignClient(value = "service-user")
public interface MUserService {

	@RequestMapping(value = "/sys/user/findMUserByUserName", method = RequestMethod.GET)
	ApiResponseEnity<MUserVo> findMUserByUserName(@RequestParam(value = "userName") String userName);
}
