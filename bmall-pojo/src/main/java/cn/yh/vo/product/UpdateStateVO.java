/**
 * 
 */
package cn.yh.vo.product;

import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.State;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public class UpdateStateVO {

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
