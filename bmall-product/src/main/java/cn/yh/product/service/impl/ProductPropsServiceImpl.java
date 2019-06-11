package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.ProductProps;
import cn.yh.product.mapper.ProductPropsMapper;
import cn.yh.product.service.IProductPropsService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-10
 */
@Service
public class ProductPropsServiceImpl extends ServiceImpl<ProductPropsMapper, ProductProps>
		implements IProductPropsService {

}
