package cn.yh.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.product.Product;
import cn.yh.vo.product.AddProductVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
public interface IProductService extends IService<Product> {

	/**
	 * 
	 * @param p
	 */
	void addProudct(AddProductVo p);
}
