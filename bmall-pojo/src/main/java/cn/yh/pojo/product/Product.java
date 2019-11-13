package cn.yh.pojo.product;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("product")
@ApiModel(value = "Product对象", description = "")
public class Product extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "商品名")
	private String name;

	@ApiModelProperty(value = "关键词")
	private String keywords;

	@ApiModelProperty(value = "商品分类ID")
	private Long categoryId;

	@ApiModelProperty(value = "品牌ID")
	private Long brandId;

	@ApiModelProperty(value = "商家ID")
	private Long userId;

	@ApiModelProperty(value = "商品价格")
	private BigDecimal price;

	@ApiModelProperty(value = "市场价格")
	private BigDecimal marketPrice;

	@ApiModelProperty(value = "封面图")
	private String img;

	@ApiModelProperty(value = "视频")
	private String video;

	@ApiModelProperty(value = "状态 (0-下架，1-上架，2-删除)")
	private Integer status;

	@ApiModelProperty(value = "审核状态 2 审核失败 0 未审核 1 审核成功")
	private Integer state;

	private LocalDateTime updateTime;

	private LocalDateTime createTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
