package cn.yh.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.product.ProductAttr;
import cn.yh.vo.product.ProductAttrVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
public interface IProductAttrService extends IService<ProductAttr> {

	void saveOrderUpdateAttrAndValue(ProductAttrVo vo);
}
