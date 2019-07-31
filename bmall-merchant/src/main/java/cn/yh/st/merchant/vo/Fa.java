/**
 * 
 */
package cn.yh.st.merchant.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yuhang
 * @date 2019年7月24日
 * @desc
 */
public class Fa {
     
	@NotNull
	private Long categroyId;
	@NotBlank
	private String name;
	private String keywords;
	private String tags;
	private String pno;
	@NotBlank
	private String img;
	private String weight;
	private Long brandId;

	public Long getCategroyId() {
		return categroyId;
	}

	public void setCategroyId(Long categroyId) {
		this.categroyId = categroyId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}
