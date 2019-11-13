package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 分类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("category")
@ApiModel(value = "Category对象", description = "分类")
public class Category extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分类名")
	private String name;

	@ApiModelProperty(value = "状态(0:禁用，1:可用)")
	private Integer state;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "父ID")
	private Long pId;

	@ApiModelProperty(value = "分级(1级,2级,3级)")
	private Integer level;

	private LocalDateTime updateTime;

	private LocalDateTime createTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
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

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
