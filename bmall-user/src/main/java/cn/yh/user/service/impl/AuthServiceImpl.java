/**
 * 
 */
package cn.yh.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.MAuth;
import cn.yh.pojo.user.MRole;
import cn.yh.pojo.user.RoleAuth;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.user.mapper.MAuthMapper;
import cn.yh.user.mapper.MRoleMapper;
import cn.yh.user.mapper.RoleAuthMapper;
import cn.yh.user.service.IAuthService;
import cn.yh.vo.user.AddRoleVo;

/**
 * @author yuhang
 * @date 2019年4月11日
 * @desc
 */
@Service
public class AuthServiceImpl extends ServiceImpl<MAuthMapper, MAuth> implements IAuthService {

	@Autowired
	private MRoleMapper mRoleMapper;
	@Autowired
	private RoleAuthMapper roleAuthMapper;

	@Override
	public List<MAuth> getAuthsByRoleId(long roleId) {
		return baseMapper.getAuthsByRoleId(roleId);
	}

	@Transactional
	@Override
	public void addEditRoleAndAuth(AddRoleVo vo) {
		if (vo.getRoleId() == null) {
			// 新增角色权限
			MRole role = new MRole();
			role.setCreateTime(new Date());
			role.setUpdateTime(role.getCreateTime());
			role.setRemark(vo.getRemark());
			role.setRoleName(vo.getRoleName());
			role.setState(vo.getState());
			int n = mRoleMapper.insert(role);
			if (n != 1) {
				throw new DefaultException("新增失败");
			}
			vo.setRoleId(role.getId());
		} else {
			MRole role = mRoleMapper.selectById(vo.getRoleId());
			if (role == null) {
				throw new DefaultException("角色不存在");
			}
			role.setUpdateTime(new Date());
			role.setRemark(vo.getRemark());
			role.setRoleName(vo.getRoleName());
			role.setState(vo.getState());
			mRoleMapper.updateById(role);
			roleAuthMapper.delete(new QueryWrapper<RoleAuth>().eq("role_id", vo.getRoleId()));
		}
		// 修改权限
		for (String m : vo.getList().split("\\,")) {
			roleAuthMapper.insert(new RoleAuth(vo.getRoleId(), Long.parseLong(m)));
		}
	}

}
