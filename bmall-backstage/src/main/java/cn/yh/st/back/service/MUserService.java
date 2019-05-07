/**
 * 
 */
package cn.yh.st.back.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yh.pojo.user.MRole;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.MUserVo;
import cn.yh.vo.user.AddRoleVo;
import cn.yh.vo.user.RoleVo;
import cn.yh.vo.user.Znodes;

/**
 * @author yuhang
 * @date 2019年4月19日
 * @desc
 */
@FeignClient(value = "service-user")
public interface MUserService {

	@RequestMapping(value = "/sys/user/findMUserByUserName", method = RequestMethod.GET)
	ApiResponseEnity<MUserVo> findMUserByUserName(@RequestParam(value = "userName") String userName);

	@GetMapping("/sys/user/findMUserByUserId")
	ApiResponseEnity<MUserVo> findMUserByUserId(@RequestParam(value = "userId") Long userId);

	@PostMapping("/role/listRole")
	List<MRole> listRole(RoleVo vo);

	@PostMapping("/auth/editRole")
	ApiResponseEnity<Boolean> editRole(AddRoleVo vo);

	@PostMapping("/auth/getAllAuth")
	List<Znodes> getAllAuth(Long roleId);
}
