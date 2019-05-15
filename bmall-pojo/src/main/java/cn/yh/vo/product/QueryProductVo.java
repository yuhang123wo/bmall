/**
 * 
 */
package cn.yh.vo.product;

import cn.yh.pojo.eumn.ProductState;
import cn.yh.pojo.eumn.ProductStatus;
import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;

/**
 * @author yuhang
 * @date 2019年5月15日
 * @desc
 */
public class QueryProductVo {

	@SearchFieldAnnotation(column = "category_id", type = SearchType.eq)
	private Long categoryId;

	@SearchFieldAnnotation(column = "user_id", type = SearchType.eq)
	private Long userId;

	@SearchFieldAnnotation(column = "state", type = SearchType.eq)
	private ProductState state;

	@SearchFieldAnnotation(column = "status", type = SearchType.eq)
	private ProductStatus status;

	@SearchFieldAnnotation(column = "create_time", type = SearchType.ge)
	private String startTime;

	@SearchFieldAnnotation(column = "create_time", type = SearchType.le)
	private String endTime;

	@SearchFieldAnnotation(column = "name", type = SearchType.likeRight)
	private String name;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
