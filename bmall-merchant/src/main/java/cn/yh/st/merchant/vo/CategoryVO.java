/**
 * 
 */
package cn.yh.st.merchant.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cn.yh.pojo.eumn.State;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhang
 * @date 2019年7月8日
 * @desc
 */
public class CategoryVO {

	private Long id;

	@ApiModelProperty(value = "分类名")
	@NotBlank(message = "分类名不能为空")
	private String name;

	@ApiModelProperty(value = "状态(0:禁用，1:可用)")
	@NotNull(message = "状态必须")
	private State state;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "父ID")
	private Long pId;

	@ApiModelProperty(value = "分级")
	@NotNull(message = "分级必须")
	private Integer level;
	
	private Long userId;

	private List<CategoryVO> list;

	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<CategoryVO> getList() {
		return list;
	}

	public void setList(List<CategoryVO> list) {
		this.list = list;
	}

}
