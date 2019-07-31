/**
 * 
 */
package cn.yh.vo.product;

import java.util.List;

/**
 * @author yuhang
 * @date 2019年7月30日
 * @desc
 */
public class Pprops {

	private Long id;
	private String groupName;
	private List<NameValue> list;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<NameValue> getList() {
		return list;
	}

	public void setList(List<NameValue> list) {
		this.list = list;
	}

}
