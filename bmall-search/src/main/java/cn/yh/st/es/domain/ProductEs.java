/**
 * 
 */
package cn.yh.st.es.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.yh.pojo.eumn.ProductState;
import cn.yh.pojo.eumn.ProductStatus;
import cn.yh.pojo.product.PRelaAttr;
import cn.yh.st.config.IndexConfig;

/**
 * @author yuhang
 * @date 2019年8月1日
 * @desc
 */
@Document(indexName = "#{indexConfig.PRODUCT_INDEX}", type = IndexConfig.PRODUCT_TYPE)
public class ProductEs {

	@Id
	private Long id;

	@Field(type = FieldType.Text, index = true, searchAnalyzer = "ik_max_word", analyzer = "ik_smart")
	private String name;

	@Field(type = FieldType.Long)
	private Long categoryId;

	@Field(type = FieldType.Long)
	private Long brandId;

	@Field(type = FieldType.Long)
	private Long userId;

	@Field(type = FieldType.Text, index = true, searchAnalyzer = "ik_max_word", analyzer = "ik_smart")
	private String keywords;

	@Field(type = FieldType.Keyword)
	private String tags;

	@Field(type = FieldType.Keyword)
	private String pno;

	@Field(type = FieldType.Double)
	private BigDecimal price;

	@Field(type = FieldType.Double)
	private BigDecimal marketPrice;

	@Field(type = FieldType.Text, index = false)
	private String img;

	@Field(type = FieldType.Text, index = false)
	private String video;

	@Field(type = FieldType.Double)
	private BigDecimal weight;

	@Field(type = FieldType.Text)
	private ProductStatus status;

	@Field(type = FieldType.Text)
	private ProductState state;

	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	@Field(type = FieldType.Keyword)
	private String weightUnit;

	@Field(type = FieldType.Keyword)
	private String brandName;

	private List<PRelaAttr> list1;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}