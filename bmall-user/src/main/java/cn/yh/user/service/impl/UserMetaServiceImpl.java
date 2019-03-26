package cn.yh.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.UserMeta;
import cn.yh.user.mapper.UserMetaMapper;
import cn.yh.user.service.IUserMetaService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-03-26
 */
@Service
public class UserMetaServiceImpl extends ServiceImpl<UserMetaMapper, UserMeta> implements IUserMetaService {

}
