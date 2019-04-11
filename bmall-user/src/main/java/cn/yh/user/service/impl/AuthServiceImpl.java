/**
 * 
 */
package cn.yh.user.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.user.MRole;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.user.mapper.MRoleMapper;
import cn.yh.user.service.IAuthService;

/**
 * @author yuhang
 * @date 2019年4月11日
 * @desc
 */
@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private MRoleMapper mRoleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.user.service.IAuthService#saveRole(cn.yh.pojo.user.MRole)
	 */
	@Transactional
	@Override
	public int saveRole(MRole role) {
		int num = mRoleMapper.selectCount(new QueryWrapper<MRole>().eq("role_name", role.getRoleName()));
		if (num > 0) {
			throw new DefaultException("角色名重复");
		}
		if (role.getState() == null) {
			role.setState(State.ENABLE);
		}
		role.setUpdateTime(new Date());
		role.setCreateTime(role.getUpdateTime());
		return mRoleMapper.insert(role);
	}

}
