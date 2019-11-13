package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 属性值
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("attr_value")
@ApiModel(value = "AttrValue对象", description = "属性值")
public class AttrValue extends Entity {

	private static final long serialVersionUID = 1L;

	private Long attrId;

	private String vName;

	@ApiModelProperty(value = "状态(0:禁用,1:启用)")
	private Integer state;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

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
