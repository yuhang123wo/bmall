package cn.yh.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.MRole;
import cn.yh.pojo.user.MUser;
import cn.yh.user.mapper.MRoleMapper;
import cn.yh.user.mapper.MUserMapper;
import cn.yh.user.service.IMUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<MRole> getRolesByUserId(long userId) {
		return mRoleMapper.getRolesByUserId(userId);
	}

}
