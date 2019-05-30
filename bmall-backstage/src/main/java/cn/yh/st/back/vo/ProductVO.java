/**
 * 
 */
package cn.yh.st.back.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yuhang
 * @date 2019年5月28日
 * @desc
 */
public class ProductVO {

	@NotBlank(message = "商品标题不能为空")
	private String name;
	@NotNull
	private Long categoryId;
	@NotBlank(message = "商品标重量不能为空")
	private String weight;
	@NotBlank(message = "商品价格不能为空")
	private String price;
	@NotBlank(message = "商品市场价格不能为空")
	private String marketPrice;
	@NotBlank(message = "商品关键题不能为空")
	private String keywords;
	@NotBlank(message = "商品说明不能为空")
	private String remark;
	@NotBlank
	private String editorValue;
	private String[] tp;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEditorValue() {
		return editorValue;
	}

	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}

	public String[] getTp() {
		return tp;
	}

	public void setTp(String[] tp) {
		this.tp = tp;
	}

}
