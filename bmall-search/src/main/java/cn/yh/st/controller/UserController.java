/**
 * 
 */
package cn.yh.st.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.mapper.Mapping;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.config.Product;
import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * @author yuhang
 * @date 2019年8月1日
 * @desc
 */
@Controller
public class UserController {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@RequestMapping("test")
	@ResponseBody
	public Object test(String a) {

		elasticsearchTemplate.createIndex(Product.class);
		elasticsearchTemplate.putMapping(Product.class);

		Product p = new Product();
		p.setBrandId(1L);
		p.setBrandName("xxx");
		p.setName("sdfhakjdshfjkjasdf");
		p.setUpdateTime(new Date());
		p.setCreateTime(new Date());
		IndexQuery inqry = new IndexQuery();
		inqry.setObject(p);
		List<IndexQuery> list = new ArrayList<IndexQuery>();
		list.add(inqry);

		elasticsearchTemplate.bulkIndex(list);

//		elasticsearchTemplate.createIndex("index_order" + a);
//elasticsearchTemplate

//		String[] existingIndex = elasticsearchTemplate.getClient().admin().indices().prepareGetAliases("testindex")
//				.execute().actionGet().getAliases().keys().toArray(String.class);
//		elasticsearchTemplate.getClient().admin().indices().prepareAliases().addAlias("index_order" + a, "testindex")
//				.execute();
//		IndicesAliasesRequestBuilder iarb = elasticsearchTemplate.getClient().admin().indices().prepareAliases();
//		for (String i : existingIndex) {
//			if (!i.equals("index_order" + a)) {
//				iarb.removeAlias(i, "testindex").execute();
//			}
//		}

		SearchRequestBuilder responsebuilder = elasticsearchTemplate.getClient().prepareSearch("testindex");
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		SearchResponse sr = responsebuilder.setFrom(1).setSize(20).setExplain(true).execute().actionGet();
		SearchHits hits = sr.getHits();
		for (int i = 0; i < hits.getHits().length; i++) {
			System.out.println(hits.getHits()[i].getSourceAsMap());
		}
		return "";
	}

}
