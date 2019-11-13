package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 平台属性值关联表
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("p_rela_attr")
@ApiModel(value = "PRelaAttr对象", description = "平台属性值关联表")
public class PRelaAttr extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "属性id（冗余)")
	private Long attrId;

	@ApiModelProperty(value = "属性值id")
	private Long valueId;

	private Long productId;

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public Long getValueId() {
		return valueId;
	}

	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
