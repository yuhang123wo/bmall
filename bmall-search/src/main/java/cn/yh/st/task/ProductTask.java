/**
 * 
 */
package cn.yh.st.task;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.yh.st.config.IndexConfig;
import cn.yh.st.es.domain.ProductEs;
import cn.yh.st.service.ProductSearchService;

/**
 * @author yuhang
 * @date 2019年8月22日
 * @desc
 */
@Component
public class ProductTask {

	@Autowired
	private ProductSearchService productSearchService;

	/**
	 * 初始创建商品结构
	 */
	public void initProduct() {
		// 创建索引
		String alias = IndexConfig.PRODUCT_INDEX;
		IndexConfig.PRODUCT_INDEX = IndexConfig.PRODUCT_INDEX + (new Date().getTime());
		productSearchService.createIndexAndMapping();

		// 插入数据
		List<ProductEs> list = new ArrayList<ProductEs>();
		for (long i = 1; i <= 10000; i++) {
			ProductEs es = new ProductEs();
			es.setBrandId(i);
			es.setId(i);
			es.setBrandName("brandName" + i);
			es.setName("商品test" + i + "xxx");
			es.setUpdateTime(new Date());
			es.setCreateTime(new Date());
			es.setKeywords("好用 方便");
			es.setMarketPrice(new BigDecimal(i));
			es.setPno("po");
			es.setTags("tags tags tags");
			es.setWeight(new BigDecimal("1"));
			list.add(es);
		}
		productSearchService.addProductIntoEs(list, IndexConfig.PRODUCT_INDEX);
		// 设置别名
		productSearchService.setUniqueAlias(IndexConfig.PRODUCT_INDEX, alias);

	}
}
