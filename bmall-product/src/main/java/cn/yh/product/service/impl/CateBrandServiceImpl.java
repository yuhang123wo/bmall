package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.CateBrand;
import cn.yh.product.mapper.CateBrandMapper;
import cn.yh.product.service.ICateBrandService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-07-16
 */
@Service
public class CateBrandServiceImpl extends ServiceImpl<CateBrandMapper, CateBrand> implements ICateBrandService {

}
