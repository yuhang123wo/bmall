package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.Specs;
import cn.yh.product.mapper.SpecsMapper;
import cn.yh.product.service.ISpecsService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@Service
public class SpecsServiceImpl extends ServiceImpl<SpecsMapper, Specs> implements ISpecsService {

}
