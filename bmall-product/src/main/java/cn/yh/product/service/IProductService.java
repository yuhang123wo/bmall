package cn.yh.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.product.Product;
import cn.yh.vo.product.AddProductVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
public interface IProductService extends IService<Product> {

	/**
	 * 新增商品
	 * @param vo
	 */
	void addProduct(AddProductVo vo);
}
