/**
 * 
 */
package cn.yh.product.strategy.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.yh.pojo.product.Brand;
import cn.yh.pojo.product.Product;
import cn.yh.product.service.IBrandService;
import cn.yh.product.service.IProductService;

/**
 * @author yuhang
 * @date 2019年9月16日
 * @desc
 */
@Component("one")
@HanderType(orderType = OrderType.A)
public class StrategyOne implements Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.seller.service.Strategy#doOperation()
	 */
	@Autowired
	private IProductService productService;

	@Autowired
	private IBrandService brandService;

	@Override
	public String doOperation() {
		System.out.println("one");

		Product p = productService.getById(1);
		System.out.println(11);
		Brand entity = new Brand();

		entity.setLogo("ggg");
		brandService.save(entity);
//		int i=1/0;
		return null;
	}

}
