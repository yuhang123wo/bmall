/**
 * 
 */
package cn.yh.vo.product;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.ProductStatus;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年5月15日
 * @desc
 */
public class AddProductVo {

	@ApiModelProperty(value = "商品标题")
	@NotBlank(message = "商品标题")
	private String name;

	@ApiModelProperty(value = "商品分类编号")
	@NotNull(message = "未选择分类")
	private Long categoryId;

	@ApiModelProperty(value = "商家ID")
	@NotNull(message = "商家为空")
	@Min(0)
	private Long userId;

	@ApiModelProperty(value = "类型编号")
	private Integer typeId;

	@ApiModelProperty(value = "简述")
	private String desc;

	@ApiModelProperty(value = "商品关键字")
	private String keywords;

	@ApiModelProperty(value = "标签")
	private String tags;

	@ApiModelProperty(value = "商品型号")
	private String marque;

	@ApiModelProperty(value = "仓库条码")
	private String barcode;

	@ApiModelProperty(value = "商品价格")
	@NotNull(message = "商品价格必填")
	@DecimalMin("0")
	private BigDecimal price;

	@ApiModelProperty(value = "市场价格")
	private BigDecimal marketPrice;

	@ApiModelProperty(value = "库存量")
	@NotNull
	@Min(0)
	private Integer stock;

	@ApiModelProperty(value = "封面图")
	@NotBlank
	private String img;

	@ApiModelProperty(value = "状态 (0-下架，1-上架，2-删除)")
	@NotNull
	private ProductStatus status;

	@ApiModelProperty(value = "重量")
	@NotNull
	private BigDecimal weight;

	@ApiModelProperty(value = "视频")
	private String video;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

}
