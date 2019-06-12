package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.ProductDetail;
import cn.yh.product.mapper.ProductDetailMapper;
import cn.yh.product.service.IProductDetailService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@Service
public class ProductDetailServiceImpl extends ServiceImpl<ProductDetailMapper,ProductDetail> implements IProductDetailService {

}
