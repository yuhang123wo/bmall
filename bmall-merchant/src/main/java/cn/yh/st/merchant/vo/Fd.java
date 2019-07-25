/**
 * 
 */
package cn.yh.st.merchant.vo;

/**
 * @author yuhang
 * @date 2019年7月24日
 * @desc
 */
public class Fd {

	private String sku;
	private String price;
	private String marketPrice;
	private Integer stock;
	private String img;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

}
