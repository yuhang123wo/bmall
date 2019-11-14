/**
 * 
 */
package cn.yh.st.common.api;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public enum CodeEnum {
	/**
	 * 处理成功
	 */
	SUCCESS(0, "处理成功"),
	/**
	 * 入参异常
	 */
	PARAMS_ERROR(1001, "入参异常"),

	/**
	 * 操作异常
	 */
	DEAL_ERROR(1002, "操作异常"),
	/**
	 * 未知异常
	 */
	UNKOWN_ERROR(1003, "未知异常");

	/**
	 * 响应代码
	 */
	private final int code;

	/**
	 * 响应消息
	 */
	private final String message;

	CodeEnum(int _code, String _message) {

		this.code = _code;
		this.message = _message;

	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * 通过枚举code获取对应的message
	 * 
	 * @return 取不到时返回null
	 */
	public static String getMessageByCode(int code) {
		for (CodeEnum _enum : values()) {
			if (_enum.getCode() == code) {
				return _enum.getMessage();
			}
		}
		return null;
	}

	/**
	 * 通过枚举code获取枚举对象
	 * 
	 * @return 取不到时返回null
	 */
	public static CodeEnum getByCode(int code) {
		for (CodeEnum _enum : values()) {
			if (_enum.getCode() == code) {
				return _enum;
			}
		}
		return null;
	}
}
