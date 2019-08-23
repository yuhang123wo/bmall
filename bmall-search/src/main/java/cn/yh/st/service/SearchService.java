/**
 * 
 */
package cn.yh.st.service;

import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.data.domain.Page;

/**
 * @author yuhang
 * @date 2019年8月20日
 * @desc
 */
public interface SearchService<T> {

	/**
	 * 设置别名
	 * 
	 * @param indexName
	 * @param alias
	 */
	void setUniqueAlias(String indexName, String alias);

	/**
	 * 添加
	 * 
	 * @param list
	 */
	void addProductIntoEs(List<T> list, String alias);

	/**
	 * 创建索引以及结构
	 * 
	 * @param t
	 * @param indexName
	 */
	void createIndexAndMapping();

	/**
	 * 
	 * @param query
	 * @return
	 */
	Page<T> queryByMap(String indexName, String type, int pageNo, int pageSize, BoolQueryBuilder boolQueryBuilder);

}
