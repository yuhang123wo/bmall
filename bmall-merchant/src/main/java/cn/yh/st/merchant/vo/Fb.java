/**
 * 
 */
package cn.yh.st.merchant.vo;

import java.util.List;

/**
 * @author yuhang
 * @date 2019年7月24日
 * @desc
 */
public class Fb {

	private Long id;
	private String group;
	private List<Nv> data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public List<Nv> getData() {
		return data;
	}

	public void setData(List<Nv> data) {
		this.data = data;
	}

}
