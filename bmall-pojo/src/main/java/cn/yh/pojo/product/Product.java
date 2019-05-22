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
 * @since 2019-05-15
 */
@TableName("product")
@ApiModel(value = "Product对象", description = "")
public class Product extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品标题")
	private String name;

	@ApiModelProperty(value = "商品分类编号")
	private Long categoryId;

	@ApiModelProperty(value = "商家ID")
	private Long userId;

	@ApiModelProperty(value = "类型编号")
	private Integer typeId;

	@ApiModelProperty(value = "简述")
	private String remark;

	@ApiModelProperty(value = "商品关键字")
	private String keywords;

	@ApiModelProperty(value = "标签")
	private String tags;

	@ApiModelProperty(value = "商品型号")
	private String marque;

	@ApiModelProperty(value = "仓库条码")
	private String barcode;

	@ApiModelProperty(value = "商品价格")
	private BigDecimal price;

	@ApiModelProperty(value = "市场价格")
	private BigDecimal marketPrice;

	@ApiModelProperty(value = "库存量")
	private Integer stock;

	@ApiModelProperty(value = "封面图")
	private String img;

	@ApiModelProperty(value = "状态 (0-下架，1-上架，2-删除)")
	private ProductStatus status;

	@ApiModelProperty(value = "审核状态 2 审核失败 0 未审核 1 审核成功")
	private ProductState state;

	private Date updateTime;

	private Date createTime;

	@ApiModelProperty(value = "重量")
	private BigDecimal weight;

	@ApiModelProperty(value = "视频")
	private String video;

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
}
