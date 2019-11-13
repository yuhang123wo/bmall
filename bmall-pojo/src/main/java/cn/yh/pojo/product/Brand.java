package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("brand")
@ApiModel(value = "Brand对象", description = "品牌")
public class Brand extends Entity {

	private static final long serialVersionUID = 1L;

	private String name;

	@ApiModelProperty(value = "状态(0:禁用,1:启用)")
	private Integer state;

	private String logo;

	private LocalDateTime updateTime;

	private LocalDateTime createTime;

	@ApiModelProperty(value = "分类ID")
	private Long categoryId;

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
