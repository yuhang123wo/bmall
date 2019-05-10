package cn.yh.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.MRole;
import cn.yh.pojo.user.MUser;
import cn.yh.pojo.user.UserRole;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.user.mapper.MRoleMapper;
import cn.yh.user.mapper.MUserMapper;
import cn.yh.user.mapper.UserRoleMapper;
import cn.yh.user.service.IMUserService;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.user.AddMuserVo;

/**
 * <p>
 * 后台用户 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-03-26
 */
@Service
public class MUserServiceImpl extends ServiceImpl<MUserMapper, MUser> implements IMUserService {

	@Autowired
	private MRoleMapper mRoleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public List<MRole> getRolesByUserId(long userId) {
		return mRoleMapper.getRolesByUserId(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yh.user.service.IMUserService#addMuserAndRole(cn.yh.vo.user.AddMuserVo)
	 */
	@Override
	@Transactional
	public void addMuserAndRole(AddMuserVo vo) {
		int count = baseMapper.selectCount(new QueryWrapper<MUser>().eq("user_name", vo.getUserName()));
		if (count > 0) {
			throw new DefaultException("用户名存在");
		}
		MUser m = ConvertUtil.convert(vo, MUser.class);
		m.setCreateTime(new Date());
		m.setUpdateTime(m.getCreateTime());
		m.setPwd(new BCryptPasswordEncoder().encode("123qwer"));
		int n = baseMapper.insert(m);
		if (n != 1) {
			throw new DefaultException("添加失败稍后再试");
		}
		// 添加角色
		UserRole userRole = new UserRole(vo.getRoleId(), m.getId());
		userRoleMapper.insert(userRole);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yh.user.service.IMUserService#updateMuserAndRole(cn.yh.vo.user.AddMuserVo)
	 */
	@Override
	@Transactional
	public void updateMuserAndRole(AddMuserVo vo) {
		MUser muser = baseMapper.selectById(vo.getUserId());
		if (muser == null) {
			throw new DefaultException("用户名存在");
		}
		muser.setUpdateTime(new Date());
		muser.setEmail(vo.getEmail());
		muser.setMobile(vo.getMobile());
		muser.setRealName(vo.getRealName());
//		muser.setPwd(new BCryptPasswordEncoder().encode(vo.getPassword()));
		muser.setState(vo.getState());
		int n = baseMapper.updateById(muser);
		if (n != 1) {
			throw new DefaultException("修改失败");
		}
		// 先删除
		userRoleMapper.delete(new QueryWrapper<UserRole>().eq("user_id", muser.getId()));
		// 添加角色
		UserRole userRole = new UserRole(vo.getRoleId(), muser.getId());
		userRoleMapper.insert(userRole);
	}

}
