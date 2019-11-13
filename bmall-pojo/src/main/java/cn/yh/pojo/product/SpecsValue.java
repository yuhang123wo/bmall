package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("specs_value")
@ApiModel(value = "SpecsValue对象", description = "")
public class SpecsValue extends Entity {

	private static final long serialVersionUID = 1L;

	private String vName;

	@ApiModelProperty(value = "状态(0:禁用,1:启用)")
	private Integer state;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
