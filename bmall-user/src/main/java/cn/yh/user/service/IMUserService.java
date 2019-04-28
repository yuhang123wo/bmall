package cn.yh.user.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.user.MRole;
import cn.yh.pojo.user.MUser;

/**
 * <p>
 * 后台用户 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-03-26
 */
public interface IMUserService extends IService<MUser> {

	/**
	 * 根据用户ID获取角色
	 * 
	 * @param userId
	 * @return
	 */
	List<MRole> getRolesByUserId(long userId);
}
