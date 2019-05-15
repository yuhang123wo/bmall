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
@TableName("product_attr_and_value")
@ApiModel(value="ProductAttrAndValue对象", description="")
public class ProductAttrAndValue extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "sku编码")
    private Long skuId;

    @ApiModelProperty(value = "属性选项编码")
    private Long vId;

    @ApiModelProperty(value = "属性编码")
    private Long attrId;

    private Long userId;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
    public Long getvId() {
        return vId;
    }

    public void setvId(Long vId) {
        this.vId = vId;
    }
    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
