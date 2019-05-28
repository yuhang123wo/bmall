/**
 * 
 */
package cn.yh.st.back.vo;

/**
 * @author yuhang
 * @date 2019年5月28日
 * @desc
 */
public class ProductVO {

	private String name;
	private String weight;
	private String price;
	private String marketPrice;
	private String keywords;
	private String remark;
	private String editorValue;
	private String[] tp;

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
