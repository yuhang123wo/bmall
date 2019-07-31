package cn.yh.pojo.product;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.ProductState;
import cn.yh.pojo.eumn.ProductStatus;
import cn.yh.st.common.Entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@TableName("product")
@ApiModel(value = "Product对象", description = "")
public class Product extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品名")
	private String name;

	@ApiModelProperty(value = "商品分类ID")
	private Long categoryId;

	@ApiModelProperty(value = "品牌ID")
	private Long brandId;

	@ApiModelProperty(value = "商家ID")
	private Long userId;

	@ApiModelProperty(value = "商品关键字")
	private String keywords;

	@ApiModelProperty(value = "标签")
	private String tags;

	@ApiModelProperty(value = "商品编号")
	private String pno;

	@ApiModelProperty(value = "商品价格")
	private BigDecimal price;

	@ApiModelProperty(value = "市场价格")
	private BigDecimal marketPrice;

	@ApiModelProperty(value = "封面图")
	private String img;

	@ApiModelProperty(value = "视频")
	private String video;

	private BigDecimal weight;

	@ApiModelProperty(value = "状态 (0-下架，1-上架，2-删除)")
	private ProductStatus status;

	@ApiModelProperty(value = "审核状态 2 审核失败 0 未审核 1 审核成功")
	private ProductState state;

	private Date updateTime;

	private Date createTime;

	@ApiModelProperty(value = "计量单位")
	private String weightUnit;

	@ApiModelProperty(value = "品牌名")
	private String brandName;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

}
