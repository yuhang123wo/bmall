package cn.yh.st.common.api;

public class ApiResponseEnity<T> {

	private int code;
	private String msg;
	private T data;

	public ApiResponseEnity() {
		this.code = CodeEnum.SUCCESS.getCode();
	}

	public ApiResponseEnity(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ApiResponseEnity(T data) {
		this.code = CodeEnum.SUCCESS.getCode();
		this.data = data;
	}

	public ApiResponseEnity(CodeEnum codeEnum) {
		this.code = codeEnum.getCode();
		this.msg = codeEnum.getMessage();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
