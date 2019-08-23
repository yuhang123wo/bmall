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
		// 设置别名
		productSearchService.setUniqueAlias(IndexConfig.PRODUCT_INDEX, alias);

	}
}
