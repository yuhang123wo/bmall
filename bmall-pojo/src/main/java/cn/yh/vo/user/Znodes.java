/**
 * 
 */
package cn.yh.vo.user;

/**
 * @author yuhang
 * @date 2019年5月6日
 * @desc
 */
public class Znodes {
	private long id;
	private String name;
	private long pId;
	private boolean open;
	private boolean checked;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
