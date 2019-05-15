package cn.yh.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.user.Consignee;
import cn.yh.user.mapper.ConsigneeMapper;
import cn.yh.user.service.IConsigneeService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 收件人配置 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
@Service
public class ConsigneeServiceImpl extends ServiceImpl<ConsigneeMapper, Consignee> implements IConsigneeService {

}
