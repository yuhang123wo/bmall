/**
 * 
 */
package cn.yh.product.strategy.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yh.pojo.product.Brand;
import cn.yh.product.service.IBrandService;

/**
 * @author yuhang
 * @date 2019年9月18日
 * @desc
 */
@Service
public class PayService {
	@Autowired
	private FactoryForStrategy factoryForStrategy;
	@Autowired
	private IBrandService brandService;

	@Transactional
	public String strategy(String key) {
		String result;
		try {
			result = factoryForStrategy.getStrategy(OrderType.A).doOperation();
		} catch (Exception e) {
			result = e.getMessage();
		}
		Brand entity = new Brand();
		entity.setAddress("ss");
		entity.setName("234234");
		entity.setCreateTime(new Date());
		entity.setLogo("ggg");
		entity.setUserId(1L);
		brandService.save(entity);
		return result;
	}
}
