package cn.yh.pojo.product;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-06-10
 */
@TableName("product_props")
@ApiModel(value="ProductProps对象", description="")
public class ProductProps extends Entity {

    private static final long serialVersionUID = 1L;

    private Long productId;

    private Long attrId;

    private String attrName;

    private Long valueId;

    private String valueName;

    private Date createTime;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }
    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }
    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
