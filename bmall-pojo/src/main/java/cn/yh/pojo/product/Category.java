package cn.yh.pojo.product;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.State;
import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@TableName("category")
@ApiModel(value = "Category对象", description = "")
public class Category extends Entity {

	private static final long serialVersionUID = 1L;

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
	private Integer level;

	private Date updateTime;

	private Date createTime;
	
	@ApiModelProperty("0:系统,其他ID:用户自定义")
	private Long userId;
	
	
	@TableField(exist=false)
	private List<Long> brand;
	
	public List<Long> getBrand() {
		return brand;
	}

	public void setBrand(List<Long> brand) {
		this.brand = brand;
	}

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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
