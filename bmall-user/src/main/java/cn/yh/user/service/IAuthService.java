/**
 * 
 */
package cn.yh.user.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.user.MAuth;

/**
 * @author yuhang
 * @date 2019年4月11日
 * @desc 权限相关service
 */
public interface IAuthService extends IService<MAuth>{

	
	
	List<MAuth> getAuthsByRoleId(long roleId);
}
