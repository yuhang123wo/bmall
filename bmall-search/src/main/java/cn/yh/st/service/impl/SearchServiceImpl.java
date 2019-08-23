/**
 * 
 */
package cn.yh.st.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.yh.st.common.util.ReflectionHelper;
import cn.yh.st.service.SearchService;

/**
 * @author yuhang
 * @date 2019年8月20日
 * @desc
 */
@Service
public class SearchServiceImpl<T> implements SearchService<T> {

	protected Class<T> clazz;

	public SearchServiceImpl() {
		clazz = ReflectionHelper.getClassGenricType(getClass());
	}

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

	@Override
	public void addProductIntoEs(List<T> list, String alias) {
		List<IndexQuery> queries = new ArrayList<IndexQuery>();
		for (int i = 0; i < list.size(); i++) {
			IndexQuery query = new IndexQuery();
			query.setObject(list.get(i));
			queries.add(query);
		}
		elasticsearchTemplate.bulkIndex(queries);

	}

	@Override
	public void createIndexAndMapping() {
		elasticsearchTemplate.createIndex(clazz);
		elasticsearchTemplate.putMapping(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.st.service.SearchService#queryByMap()
	 */
	@Override
	public Page<T> queryByMap(String indexName, String type, int pageNo, int pageSize,	BoolQueryBuilder boolQueryBuilder) {
		SearchRequestBuilder responsebuilder = elasticsearchTemplate.getClient().prepareSearch(indexName)
				.setTimeout(new TimeValue(30 * 1000)).setTypes(type);
		responsebuilder.setQuery(boolQueryBuilder);
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		SearchResponse sr = responsebuilder.setFrom(pageNo * pageSize).setSize(pageSize).setExplain(false).execute()
				.actionGet(10 * 1000);
		SearchHits hits = sr.getHits();
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < hits.getHits().length; i++) {
			list.add(JSON.parseObject(JSON.toJSONString(hits.getHits()[i].getSource()), clazz));
		}
		Page<T> pageData = new PageImpl<T>(list, pageRequest, hits.getTotalHits());
		return pageData;
	}
}
