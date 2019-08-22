/**
 * 
 */
package cn.yh.st.controller;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.config.IndexConfig;
import cn.yh.st.service.ProductSearchService;
import cn.yh.st.task.ProductTask;

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
	public Object test(String a) {
		productTask.initProduct();
		return productSearchService.queryByMap(IndexConfig.PRODUCT_INDEX, IndexConfig.PRODUCT_TYPE, 1, 20);
	}

}
