/**
 * 
 */
package cn.yh.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.MAuth;
import cn.yh.user.mapper.MAuthMapper;
import cn.yh.user.service.IAuthService;

/**
 * @author yuhang
 * @date 2019年4月11日
 * @desc
 */
@Service
public class AuthServiceImpl extends ServiceImpl<MAuthMapper, MAuth> implements IAuthService {

	@Override
	public List<MAuth> getAuthsByRoleId(long roleId) {
		return baseMapper.getAuthsByRoleId(roleId);
	}

}
