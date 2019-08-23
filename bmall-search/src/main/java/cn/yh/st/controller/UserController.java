/**
 * 
 */
package cn.yh.st.controller;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.config.IndexConfig;
import cn.yh.st.es.domain.QueryProduct;
import cn.yh.st.service.ProductSearchService;
import cn.yh.st.task.ProductTask;
import cn.yh.st.util.SearchQuery;

/**
 * @author yuhang
 * @date 2019年8月1日
 * @desc
 */
@Controller
public class UserController {

	@Autowired
	private ProductTask productTask;

	@Autowired
	private ProductSearchService productSearchService;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@RequestMapping("test")
	@ResponseBody
	public Object test(QueryProduct p) {
		BoolQueryBuilder boolQueryBuilder = SearchQuery.getQuery(p);
		return productSearchService.queryByMap(IndexConfig.PRODUCT_INDEX, IndexConfig.PRODUCT_TYPE, 0, 20,
				boolQueryBuilder);
	}

}
