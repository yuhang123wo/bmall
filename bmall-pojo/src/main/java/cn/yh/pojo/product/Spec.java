package cn.yh.pojo.product;

import java.util.Date;

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
@TableName("spec")
@ApiModel(value = "Spec对象", description = "")
public class Spec extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分类ID")
	private Long categoryId;

	@ApiModelProperty(value = "规格名")
	private String name;

	@ApiModelProperty(value = "状态(0:禁用,1:启用)")
	private State state;

	private Date createTime;

	private Date updateTime;

	@ApiModelProperty("0:系统,大于0:用户自定义")
	private Long userId;
	
	
	private String data;
	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
