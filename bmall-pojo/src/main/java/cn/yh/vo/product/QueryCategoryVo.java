/**
 * 
 */
package cn.yh.vo.product;

import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;
import cn.yh.vo.BasePage;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
public class QueryCategoryVo extends BasePage {

	@SearchFieldAnnotation(column = "name", type = SearchType.likeLeft)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
