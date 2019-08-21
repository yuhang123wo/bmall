/**
 * 
 */
package cn.yh.st.service;

import java.util.List;

import cn.yh.pojo.product.Product;

/**
 * @author yuhang
 * @date 2019年8月20日
 * @desc
 */
public interface ProductSearchService {

	/**
	 * 设置别名
	 * 
	 * @param indexName
	 * @param alias
	 */
	void setUniqueAlias(String indexName, String alias);

	/**
	 * 添加商品
	 * 
	 * @param list
	 */
	void addProductIntoEs(List<Product> list, String alias);

}
