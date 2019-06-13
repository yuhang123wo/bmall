/**
 * 
 */
package cn.yh.vo.product;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.AttrValue;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
public class AddAttrVo {

	@NotBlank(message = "名称不能为空")
	private String name;

	@NotNull
	private Long categoryId;

	@NotNull
	private State state;

	@NotEmpty
	private List<AttrValue> list;

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

	public List<AttrValue> getList() {
		return list;
	}

	public void setList(List<AttrValue> list) {
		this.list = list;
	}

}
