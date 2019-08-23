/**
 * 
 */
package cn.yh.st.es.domain;

import cn.yh.pojo.eumn.ProductState;
import cn.yh.pojo.eumn.ProductStatus;
import cn.yh.st.common.annotation.SearchEsFieldAnnotation;
import cn.yh.st.common.annotation.Type;

/**
 * @author yuhang
 * @date 2019年8月23日
 * @desc
 */
public class QueryProduct {

	@SearchEsFieldAnnotation(column = "id", type = Type.TERMQUERY)
	private Long id;

	@SearchEsFieldAnnotation(column = "name", type = Type.PHRASEQUERY)
	private String name;

	@SearchEsFieldAnnotation(column = "categoryId", type = Type.TERMQUERY)
	private Long categoryId;

	@SearchEsFieldAnnotation(column = "brandId", type = Type.TERMQUERY)
	private Long brandId;

	@SearchEsFieldAnnotation(column = "userId", type = Type.TERMQUERY)
	private Long userId;

	@SearchEsFieldAnnotation(column = "keywords", type = Type.PHRASEQUERY)
	private String keywords;

	@SearchEsFieldAnnotation(column = "tags", type = Type.PHRASEQUERY)
	private String tags;

	@SearchEsFieldAnnotation(column = "pno", type = Type.PHRASEQUERY)
	private String pno;

	@SearchEsFieldAnnotation(column = "status", type = Type.TERMQUERY)
	private ProductStatus status;

	@SearchEsFieldAnnotation(column = "state", type = Type.TERMQUERY)
	private ProductState state;

	@SearchEsFieldAnnotation(column = "createTime", type = Type.TIMEQUERYBEGIN)
	private String startTime;

	@SearchEsFieldAnnotation(column = "createTime", type = Type.TIMEQUERYEND)
	private String endTime;

	@SearchEsFieldAnnotation(column = "state", type = Type.TERMQUERY)
	private String brandName;

	@SearchEsFieldAnnotation(column = "attrList.attrName", nestedPath = "attrList", type = Type.PHRASEQUERY_NEST)
	private String attrName;

	@SearchEsFieldAnnotation(column = "attrList.vName", nestedPath = "attrList", type = Type.PHRASEQUERY_NEST)
	private String vName;

	@SearchEsFieldAnnotation(column = "state", type = Type.PHRASEQUERY)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
