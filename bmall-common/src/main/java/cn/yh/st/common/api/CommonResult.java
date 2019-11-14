/**
 * 
 */
package cn.yh.st.common.api;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public class CommonResult {

	public static final int CODE_SUCCESS = 0;

	public static final int CODE_FAIL = -1;

	private int code;

	private String msg;

	private Object data;

	public CommonResult() {
		super();
	}

	public CommonResult(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public CommonResult(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
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

	public boolean isSuccess() {
		if (this.code == CODE_SUCCESS)
			return true;
		return false;
	}
}
