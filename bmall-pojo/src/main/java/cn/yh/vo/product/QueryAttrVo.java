/**
 * 
 */
package cn.yh.vo.product;

import cn.yh.pojo.eumn.State;
import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;
import cn.yh.vo.BasePage;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public class QueryAttrVo extends BasePage {

	@SearchFieldAnnotation(column = "name", type = SearchType.likeRight)
	private String name;

	@SearchFieldAnnotation(column = "state", type = SearchType.eq)
	private State state;

	@SearchFieldAnnotation(column = "category_id", type = SearchType.eq)
	private Long categoryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
