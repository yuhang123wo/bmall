/**
 * 
 */
package cn.yh.vo.product;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@ApiModelProperty(value = "封面图")
	@NotBlank
	private String img;

	@ApiModelProperty(value = "视频")
	private String video;

	@NotNull
	private BigDecimal weight;

	@ApiModelProperty(value = "计量单位")
	private String weightUnit;

	private List<PAttr> attrList;

	private List<Pprops> propsList;

	private SKu sku;

	private String detail;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public SKu getSku() {
		return sku;
	}

	public void setSku(SKu sku) {
		this.sku = sku;
	}

	public List<Pprops> getPropsList() {
		return propsList;
	}

	public void setPropsList(List<Pprops> propsList) {
		this.propsList = propsList;
	}

	public List<PAttr> getAttrList() {
		return attrList;
	}

	public void setAttrList(List<PAttr> attrList) {
		this.attrList = attrList;
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

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

}
