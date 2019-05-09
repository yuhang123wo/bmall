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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.user.MRole;
import cn.yh.pojo.user.MUser;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.MUserVo;
import cn.yh.vo.user.AddMuserVo;
import cn.yh.vo.user.AddRoleVo;
import cn.yh.vo.user.QueryMuserVO;
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
	List<Znodes> getAllAuth(@RequestParam("roleId") Long roleId);

	@PostMapping("/role/getRoleById")
	MRole getRoleById(@RequestParam("roleId") Long roleId);

	@PostMapping("/role/updateRoleState")
	ApiResponseEnity<Boolean> updateRoleState(@RequestParam("roleId") Long roleId, @RequestParam("state") State state);

	@PostMapping("/sys/user/queryMuser")
	ApiResponseEnity<Page<MUser>> queryMuser(QueryMuserVO vo);
	
	@PostMapping("/sys/user/editMUser")
	ApiResponseEnity<?> editMUser(AddMuserVo vo);

}
