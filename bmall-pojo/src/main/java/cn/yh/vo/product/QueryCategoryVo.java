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
 * @date 2019年6月12日
 * @desc
 */
public class QueryCategoryVo extends BasePage {

	@SearchFieldAnnotation(column = "name", type = SearchType.likeLeft)
	private String name;

	private Long userId;
	
	@SearchFieldAnnotation(column = "state", type = SearchType.eq)
	private State state;

	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
