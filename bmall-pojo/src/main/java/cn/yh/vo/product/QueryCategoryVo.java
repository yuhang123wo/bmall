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
public class QueryCategoryVo extends BasePage{

	@SearchFieldAnnotation(column = "state", type = SearchType.eq)
	private State state;

	@SearchFieldAnnotation(column = "p_id", type = SearchType.eq)
	private String pId;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

}
