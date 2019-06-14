/**
 * 
 */
package cn.yh.vo.product;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yuhang
 * @date 2019年6月13日
 * @desc
 */
public class AddProductSkuVo {

	private String price;
	private int stock;
	private String img;
	private List<SkuVo> sku;

	public List<SkuVo> getSku() {
		return sku;
	}

	public void setSku(List<SkuVo> sku) {
		this.sku = sku;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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
