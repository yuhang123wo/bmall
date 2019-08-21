/**
 * 
 */
package cn.yh.st.service.impl;

import java.util.Date;
import java.util.List;

import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

import cn.yh.pojo.product.Product;
import cn.yh.st.service.ProductSearchService;

/**
 * @author yuhang
 * @date 2019年8月20日
 * @desc
 */
@Service
public class ProductSearchServiceImpl implements ProductSearchService {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public void setUniqueAlias(String indexName, String alias) {
		String[] existingIndex = getExistingIndex(alias);
		elasticsearchTemplate.getClient().admin().indices().prepareAliases().addAlias(indexName, alias).execute();
		IndicesAliasesRequestBuilder iarb = elasticsearchTemplate.getClient().admin().indices().prepareAliases();
		for (String i : existingIndex) {
			if (!i.equals(indexName)) {
				iarb.removeAlias(i, alias).execute();
			}
		}
	}

	private String[] getExistingIndex(String alias) {
		return elasticsearchTemplate.getClient().admin().indices().prepareGetAliases(alias).execute().actionGet()
				.getAliases().keys().toArray(String.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.st.service.ProductSearchService#addProductIntoEs(java.util.List)
	 */
	@Override
	public void addProductIntoEs(List<Product> list, String alias) {
//		IndexQuery IndexQuery = new IndexQuery();
//		IndexQuery.setObject(new Product("1", 1, new Date(), "111xxxxx" + a));
//		IndexQuery.setIndexName("testindex");
//		elasticsearchTemplate.index(IndexQuery);
	}

}
