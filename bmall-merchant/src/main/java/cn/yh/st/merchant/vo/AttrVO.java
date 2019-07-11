/**
 * 
 */
package cn.yh.st.merchant.vo;

import java.util.List;

/**
 * @author yuhang
 * @date 2019年7月10日
 * @desc
 */
public class AttrVO {
	private Long categoryId;
	private String name;
	private List<String> data;

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

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}



}
