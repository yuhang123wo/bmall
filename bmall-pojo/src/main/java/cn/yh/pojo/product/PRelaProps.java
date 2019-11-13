package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 商品props
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("p_rela_props")
@ApiModel(value = "PRelaProps对象", description = "商品props")
public class PRelaProps extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "props值")
	private String data;

	private Long productId;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
