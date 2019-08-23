/**
 * 
 */
package cn.yh.st.es.domain;

import java.math.BigDecimal;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import cn.yh.pojo.eumn.State;

/**
 * @author yuhang
 * @date 2019年8月23日
 * @desc
 */
public class ProductSkuEs {
	@Field(type = FieldType.Long)
	private Long id;

	@Field(type = FieldType.Long)
	private Long productId;

	@Field(type = FieldType.Text)
	private String img;

	@Field(type = FieldType.Double)
	private BigDecimal price;

	@Field(type = FieldType.Integer)
	private Integer stock;

	@Field(type = FieldType.Text)
	private String data;

	@Field(type = FieldType.Text)
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
