package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.Props;
import cn.yh.product.mapper.PropsMapper;
import cn.yh.product.service.IPropsService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品参数 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@Service
public class PropsServiceImpl extends ServiceImpl<PropsMapper, Props> implements IPropsService {

}
