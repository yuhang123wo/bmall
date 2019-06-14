package cn.yh.pojo.product;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.State;
import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-06-13
 */
@TableName("brand")
@ApiModel(value = "Brand对象", description = "")
public class Brand extends Entity {

	private static final long serialVersionUID = 1L;

	private String name;

	private Long categoryId;

	private State state;

	private Date createTime;

	private Date updateTime;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Brand{" + "name=" + name + ", categoryId=" + categoryId + ", state=" + state + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "}";
	}
}
