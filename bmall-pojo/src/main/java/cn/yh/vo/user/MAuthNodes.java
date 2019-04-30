/**
 * 
 */
package cn.yh.vo.user;

import java.util.List;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
public class MAuthNodes {

	private Long id;
	private String authName;
	private Long pId;
	private List<MAuthNodes> child;

	public MAuthNodes() {
		super();
	}

	public MAuthNodes(Long id, String authName, Long pId) {
		super();
		this.id = id;
		this.authName = authName;
		this.pId = pId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public List<MAuthNodes> getChild() {
		return child;
	}

	public void setChild(List<MAuthNodes> child) {
		this.child = child;
	}

}
