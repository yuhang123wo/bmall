package cn.yh.pojo.product;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.State;
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
@TableName("product_sku")
@ApiModel(value = "Sku对象", description = "")
public class ProductSku extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品ID")
	private Long productId;

	@ApiModelProperty(value = "主图")
	private String img;

	@ApiModelProperty(value = "价格")
	private BigDecimal price;

	@ApiModelProperty(value = "库存")
	private Integer stock;

	@ApiModelProperty(value = "sku串")
	private String data;

	private Date createTime;

	private Date updateTime;

	@ApiModelProperty(value = "状态(0:禁用 1:启用)")
	private State state;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
