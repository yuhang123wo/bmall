package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.KeyWords;
import cn.yh.product.mapper.KeyWordsMapper;
import cn.yh.product.service.IKeyWordsService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@Service
public class KeyWordsServiceImpl extends ServiceImpl<KeyWordsMapper, KeyWords> implements IKeyWordsService {

}
