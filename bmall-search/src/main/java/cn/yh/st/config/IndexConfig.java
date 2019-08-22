/**
 * 
 */
package cn.yh.st.config;

import org.springframework.stereotype.Component;

/**
 * @author yuhang
 * @date 2019年8月1日
 * @desc
 */
@Component
public class IndexConfig {

	/**
	 * 商品es索引别名
	 */
	public static String PRODUCT_INDEX = "productindex";

	/**
	 * 商品es索引type
	 */
	public static final String PRODUCT_TYPE = "producttye";
}
