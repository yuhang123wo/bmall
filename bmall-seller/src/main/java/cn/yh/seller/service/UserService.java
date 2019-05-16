/**
 * 
 */
package cn.yh.seller.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yh.vo.MUserVo;

/**
 * @author yuhang
 * @date 2019年4月15日
 * @desc
 */
@FeignClient(value = "service-user")
public interface UserService {

	@RequestMapping(value = "/sys/user/findMUserByUserName", method = RequestMethod.GET)
    MUserVo findMUserByUserName(@RequestParam(value = "userName") String userName);


}
