/**
 * 
 */
package cn.yh.vo.product;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.State;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
public class AddSpecVo {

	@NotBlank(message = "名称不能为空")
	private String name;

	@NotNull
	private Long categoryId;

	@NotNull
	private State state;

	@NotNull
	private Long userId;

	@NotEmpty
	private List<String> list;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
