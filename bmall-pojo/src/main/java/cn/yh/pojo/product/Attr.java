package cn.yh.pojo.product;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 属性
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("attr")
@ApiModel(value = "Attr对象", description = "属性")
public class Attr extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "属性名")
	private String name;

	@ApiModelProperty(value = "状态(0:禁用,1:可用)")
	private Integer state;

	@ApiModelProperty(value = "分类ID")
	private Long categoryId;

	private LocalDateTime createTime = LocalDateTime.now();

	private LocalDateTime updateTime = LocalDateTime.now();

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
}
