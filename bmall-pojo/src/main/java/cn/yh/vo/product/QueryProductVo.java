/**
 * 
 */
package cn.yh.vo.product;

import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;
import cn.yh.vo.BasePage;

/**
 * @author yuhang
 * @date 2019年6月13日
 * @desc
 */
public class QueryProductVo extends BasePage {

	@SearchFieldAnnotation(column = "name", type = SearchType.likeRight)
	private String name;

	private Long categoryId;

	@SearchFieldAnnotation(column = "brand_id", type = SearchType.eq)
	private Long brandId;

	@SearchFieldAnnotation(column = "user_id", type = SearchType.eq)
	private Long userId;

	@SearchFieldAnnotation(column = "status", type = SearchType.eq)
	private Integer status;

	@SearchFieldAnnotation(column = "status", type = SearchType.eq)
	private Integer state;

	@SearchFieldAnnotation(column = "create_time", type = SearchType.lt)
	private String startTime;

	@SearchFieldAnnotation(column = "create_time", type = SearchType.gt)
	private String endTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

}
