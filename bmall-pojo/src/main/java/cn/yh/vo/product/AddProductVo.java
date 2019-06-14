/**
 * 
 */
package cn.yh.vo.product;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.ProductStatus;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年6月13日
 * @desc
 */
public class AddProductVo {

	@ApiModelProperty(value = "商品名")
	@NotBlank
	private String name;

	@ApiModelProperty(value = "商品分类ID")
	@NotNull
	private Long categoryId;

	@ApiModelProperty(value = "品牌ID")
	private Long brandId;

	@ApiModelProperty(value = "商家ID")
	@NotNull
	private Long userId;

	@ApiModelProperty(value = "商品关键字")
	@NotBlank
	private String keywords;

	@ApiModelProperty(value = "标签")
	@NotBlank
	private String tags;

	@ApiModelProperty(value = "商品编号")
	@NotBlank
	private String pno;

	@ApiModelProperty(value = "商品价格")
	@NotNull
	private String price;

	@ApiModelProperty(value = "市场价格")
	@NotNull
	private String marketPrice;

	@ApiModelProperty(value = "库存量")
	@NotNull
	private Integer stock;

	@ApiModelProperty(value = "封面图")
	@NotBlank
	private String img;

	@ApiModelProperty(value = "视频")
	private String video;

	@NotNull
	private BigDecimal weight;

	@ApiModelProperty(value = "状态 (0-下架，1-上架，2-删除)")
	@NotNull
	private ProductStatus status;

	@ApiModelProperty(value = "计量单位")
	@NotBlank
	private String weightUnit;

	// 属性集合
	private List<AddProductAttrVo> attrValueList;
	// 参数集合
	private List<String> props;

	private List<AddProductSkuVo> skuList;

	@NotEmpty
	private List<String> images;

	private String description;

	public List<AddProductAttrVo> getAttrValueList() {
		return attrValueList;
	}

	public void setAttrValueList(List<AddProductAttrVo> attrValueList) {
		this.attrValueList = attrValueList;
	}

	public List<String> getProps() {
		return props;
	}

	public void setProps(List<String> props) {
		this.props = props;
	}

	public List<AddProductSkuVo> getSkuList() {
		return skuList;
	}

	public void setSkuList(List<AddProductSkuVo> skuList) {
		this.skuList = skuList;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice) {
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

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

}
