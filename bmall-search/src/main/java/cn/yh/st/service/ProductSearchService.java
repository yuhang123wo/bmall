/**
 * 
 */
package cn.yh.st.service;

import cn.yh.st.es.domain.ProductEs;
import cn.yh.vo.es.ProductSearchVo;

/**
 * @author yuhang
 * @date 2019年8月22日
 * @desc
 */
public interface ProductSearchService extends SearchService<ProductEs> {

	/**
	 * 商品同步进es
	 * 
	 * @param productId
	 */
	void addProductEs(ProductSearchVo vo);
}
