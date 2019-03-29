package cn.yh.st.common.api;

public class ApiResponseEnity<T> {

	public static final String CODE_SUCCESS = "0";
	public static final String CODE_FAIL = "-1";
	private String code;
	private String msg;
	private T data;

	public ApiResponseEnity() {
		this.code = CODE_SUCCESS;
	}

	public ApiResponseEnity(T data) {
		this.code = CODE_SUCCESS;
		this.data = data;
	}

	public ApiResponseEnity(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ApiResponseEnity<T> fail(String msg) {
		this.code = CODE_FAIL;
		this.msg = msg;
		return this;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
