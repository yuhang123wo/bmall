/**
 * 
 */
package cn.yh.vo.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.State;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
public class UpdateStateVo {

	@NotNull
	private Long id;
	@NotNull
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
