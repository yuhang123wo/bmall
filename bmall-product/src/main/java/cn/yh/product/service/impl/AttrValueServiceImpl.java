package cn.yh.product.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.AttrValue;
import cn.yh.product.mapper.AttrValueMapper;
import cn.yh.product.service.IAttrValueService;

/**
 * <p>
 * 属性 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue> implements IAttrValueService {
}
