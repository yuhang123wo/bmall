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
 * @since 2019-06-12
 */
@TableName("p_rela_spec")
@ApiModel(value="PRelaSpec对象", description="")
public class PRelaSpec extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格ID")
    private Long specId;

    @ApiModelProperty(value = "规格名")
    private String specName;

    @ApiModelProperty(value = "规格值ID")
    private Long vId;

    @ApiModelProperty(value = "规格值名")
    private String vName;

    @ApiModelProperty(value = "商品ID")
    private Long productId;

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }
    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
    public Long getvId() {
        return vId;
    }

    public void setvId(Long vId) {
        this.vId = vId;
    }
    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
