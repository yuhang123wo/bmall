package cn.yh.pojo.eumn;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum UserType {
	PURCHASE(1, "采购"), ENABLE(2, "厂商");

	UserType(int code, String remark) {
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