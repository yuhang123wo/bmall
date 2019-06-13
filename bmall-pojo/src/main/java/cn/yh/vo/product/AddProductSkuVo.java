/**
 * 
 */
package cn.yh.vo.product;

import java.math.BigDecimal;

/**
 * @author yuhang
 * @date 2019年6月13日
 * @desc
 */
public class AddProductSkuVo {

	private long specId;
	private String specName;
	private long specValueId;
	private String specValueName;
	private BigDecimal price;
	private int stock;
	private String img;

	public long getSpecId() {
		return specId;
	}

	public void setSpecId(long specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public long getSpecValueId() {
		return specValueId;
	}

	public void setSpecValueId(long specValueId) {
		this.specValueId = specValueId;
	}

	public String getSpecValueName() {
		return specValueName;
	}

	public void setSpecValueName(String specValueName) {
		this.specValueName = specValueName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
