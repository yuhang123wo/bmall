package cn.yh.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.MUser;
import cn.yh.user.mapper.MUserMapper;
import cn.yh.user.service.IMUserService;

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

}
