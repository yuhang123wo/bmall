package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("product_attr")
@ApiModel(value = "ProductAttr对象", description = "")
public class ProductAttr extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品编码")
	private Integer productId;

	@ApiModelProperty(value = "规格名称")
	private String name;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
