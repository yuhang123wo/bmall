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
@TableName("product_attr_value")
@ApiModel(value="ProductAttrValue对象", description="")
public class ProductAttrValue extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "选项名称")
    private String name;

    @ApiModelProperty(value = "属性编码")
    private Long attrId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }
}
