package cn.yh.pojo.eumn;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum UserState {
	DISABLE(0, "禁用"), ENABLE(1, "启用"), DEL(2, "删除");

	UserState(int code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	@EnumValue
	private int code;

	private String remark;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}