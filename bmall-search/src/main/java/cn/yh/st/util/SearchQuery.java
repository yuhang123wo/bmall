/**
 * 
 */
package cn.yh.st.util;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.ScriptQueryBuilder;
import org.elasticsearch.script.Script;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import cn.yh.st.common.annotation.SearchEsFieldAnnotation;
import cn.yh.st.common.annotation.Type;

/**
 * @author yuhang
 * @date 2019年8月23日
 * @desc
 */
public class SearchQuery {
	public static BoolQueryBuilder getQuery(Object vo) {
		BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
		Field[] fields = vo.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			boolean flag = f.isAnnotationPresent(SearchEsFieldAnnotation.class);
			if (!flag) {
				continue;
			}
			Object queryValue = getFieldValue(f, vo);
			if (queryValue != null && StringUtils.isNotBlank(queryValue.toString())) {
				SearchEsFieldAnnotation sf = f.getAnnotation(SearchEsFieldAnnotation.class);
				String queryName = sf.column();
				Type queryType = sf.type();
				switch (queryType) {
				case IDQUERY:
					boolQueryBuilder.must(QueryBuilders.idsQuery().addIds(queryValue.toString().split(",")));
					break;
				case REGEXPEQUERY:
					boolQueryBuilder.must(QueryBuilders.matchQuery(queryName, queryValue.toString()));
					break;
				case REGEXPE2QUERY:
					boolQueryBuilder.must(QueryBuilders.wildcardQuery(queryName, "*" + queryValue.toString() + "*"));
					break;
				case WILDCARDQUERY:
					boolQueryBuilder.must(QueryBuilders.wildcardQuery(queryName, "*" + queryValue.toString() + "*"));
					break;
				case PHRASEQUERY:
					boolQueryBuilder.must(QueryBuilders.matchPhraseQuery(queryName, queryValue));
					break;
				case PHRASEQUERY_NEST:
					boolQueryBuilder.must(QueryBuilders.nestedQuery(sf.nestedPath(),
							QueryBuilders.matchPhraseQuery(queryName, queryValue), ScoreMode.None));
					break;
				case TERMQUERY_NEST:
					boolQueryBuilder.must(QueryBuilders.nestedQuery(sf.nestedPath(),
							QueryBuilders.termQuery(queryName, queryValue), ScoreMode.None));
					break;
				case ANDOPERQUERY:
					String queryString = String.format("(doc['%s'].value & %s) == %s", queryName, queryValue,
							queryValue);
					ScriptQueryBuilder queryBuilder = QueryBuilders.scriptQuery(new Script(queryString));
					boolQueryBuilder.must(queryBuilder);
					break;
				case NEQANDOPERQUERY:
					String queryString$2 = String.format("(doc['%s'].value & %s) != %s", queryName, queryValue,
							queryValue);
					ScriptQueryBuilder queryBuilder$2 = QueryBuilders.scriptQuery(new Script(queryString$2));
					boolQueryBuilder.must(queryBuilder$2);
					break;
				case TERMQUERY:
					boolQueryBuilder.must(QueryBuilders.termQuery(queryName, queryValue));
					break;
				case NOTNULLQUERY:
					String queryString$3 = String.format("doc['%s'].value != null", queryName);
					ScriptQueryBuilder queryBuilder$3 = QueryBuilders.scriptQuery(new Script(queryString$3));
					boolQueryBuilder.must(queryBuilder$3);
					break;
				case EQNULLQUERY:
					String queryString$4 = String.format("doc['%s'].value == null", queryName);
					ScriptQueryBuilder queryBuilder$4 = QueryBuilders.scriptQuery(new Script(queryString$4));
					boolQueryBuilder.must(queryBuilder$4);
					break;
				case TERMQUERYBATCH:
					boolQueryBuilder.must(QueryBuilders.termsQuery(queryName, (List) queryValue));
					break;
				case TIMEQUERYBEGIN:
					RangeQueryBuilder dateQuery = QueryBuilders.rangeQuery(queryName);
					if (queryValue != null) {
						dateQuery.from(queryValue.toString());
					}
					boolQueryBuilder.must(dateQuery.format("yyyy-MM-dd HH:mm:ss"));
					break;
				case TIMEQUERYEND:
					RangeQueryBuilder dateQuery1 = QueryBuilders.rangeQuery(queryName);
					if (queryValue != null) {
						dateQuery1.to(queryValue.toString());
					}
					boolQueryBuilder.must(dateQuery1.format("yyyy-MM-dd HH:mm:ss"));
					break;
				default:
					break;
				}
			}

		}
		return boolQueryBuilder;
	}

	private static Object getFieldValue(Field f, Object vo) {
		try {
			// 设置可以访问私有变量
			f.setAccessible(true);
			return f.get(vo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
