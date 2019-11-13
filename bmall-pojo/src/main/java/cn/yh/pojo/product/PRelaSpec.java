package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * sku平台属性值关联表
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("p_rela_spec")
@ApiModel(value = "PRelaSpec对象", description = "sku平台属性值关联表")
public class PRelaSpec extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "属性id（冗余)")
	private Long specId;

	@ApiModelProperty(value = "属性值id")
	private Long valueId;

	@ApiModelProperty(value = "skuid")
	private Long skuId;

	private Long productId;

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public Long getValueId() {
		return valueId;
	}

	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
