package cn.yh.pojo.product;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;
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
@TableName("product_sku")
@ApiModel(value = "ProductSku对象", description = "")
public class ProductSku extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品编码")
	private Long productId;

	@ApiModelProperty(value = "sku名称")
	private String name;

	@ApiModelProperty(value = "主图")
	private String img;

	@ApiModelProperty(value = "价格")
	private BigDecimal price;

	@ApiModelProperty(value = "库存")
	private Integer stock;

	@ApiModelProperty(value = "商品编码")
	private String code;

	@ApiModelProperty(value = "商品条形码")
	private String barcode;

	@ApiModelProperty(value = "sku串")
	private String data;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
