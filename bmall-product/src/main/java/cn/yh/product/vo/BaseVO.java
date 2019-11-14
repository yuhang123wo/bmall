/**
 * 
 */
package cn.yh.product.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public class BaseVO {

	@NotNull(message = "id缺失")
	@Min(value = 0, message = "输入正确id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
