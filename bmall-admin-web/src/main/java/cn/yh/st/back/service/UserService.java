/**
 * 
 */
package cn.yh.st.back.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yh.vo.UserVo;

/**
 * @author yuhang
 * @date 2019年4月15日
 * @desc
 */
@FeignClient(value = "service-user")
public interface UserService {

	@RequestMapping(value = "/user/getUserBaseInfoById", method = RequestMethod.GET)
	UserVo sayHiFromClientOne(@RequestParam(value = "userId") Long userId);

}
