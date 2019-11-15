/**
 * 
 */
package cn.yh.st.common;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public class Message {

	public int code;
	public String msg;
	public Object data;

	public static final int CODE_SUCCESS = 0;
	public static final int CODE_FAIL = -1;

	public Message() {
		this.code = CODE_SUCCESS;
	}

	public Message(Object data) {
		this.code = CODE_SUCCESS;
		this.data = data;
	}

	public Message fail(String msg) {
		this.code = CODE_FAIL;
		this.msg = msg;
		return this;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
