package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.Attr;
import cn.yh.product.mapper.AttrMapper;
import cn.yh.product.service.IAttrService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 属性 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {

}
