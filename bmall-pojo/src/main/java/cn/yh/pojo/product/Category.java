package cn.yh.pojo.product;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
 * @since 2019-05-15
 */
@TableName("category")
@ApiModel(value = "Category对象", description = "")
public class Category extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分类名")
	@NotBlank(message = "分类名不能为空")
	private String categoryName;

	@ApiModelProperty(value = "父ID")
	@NotNull(message = "父ID不能为空,顶级ID为0")
	private Long pId;

	@ApiModelProperty(value = "状态(0:无效，1：有效)")
	@NotNull(message = "状态")
	private State state;

	private Date updateTime;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
