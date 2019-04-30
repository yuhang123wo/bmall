package cn.yh.user.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.MRole;
import cn.yh.user.mapper.MRoleMapper;
import cn.yh.user.service.IMRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-04-11
 */
@Service
public class MRoleServiceImpl extends ServiceImpl<MRoleMapper, MRole> implements IMRoleService {

}
