package cn.yh.pojo.product;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 库存单元表
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("product_sku")
@ApiModel(value = "Sku对象", description = "库存单元表")
public class Sku extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品id")
	private Long productId;

	@ApiModelProperty(value = "价格")
	private BigDecimal price;

	@ApiModelProperty(value = "sku名称")
	private String skuName;

	@ApiModelProperty(value = "商品规格描述")
	private String skuDesc;

	private BigDecimal weight;

	@ApiModelProperty(value = "图片")
	private String img;

	@ApiModelProperty(value = "库存量")
	private Integer stockNum;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	@ApiModelProperty(value = "状态(0禁用,1启用)")
	private Integer state;

	@ApiModelProperty(value = "sku关联ID")
	private Long pRelaSpecId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuDesc() {
		return skuDesc;
	}

	public void setSkuDesc(String skuDesc) {
		this.skuDesc = skuDesc;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getpRelaSpecId() {
		return pRelaSpecId;
	}

	public void setpRelaSpecId(Long pRelaSpecId) {
		this.pRelaSpecId = pRelaSpecId;
	}
}
