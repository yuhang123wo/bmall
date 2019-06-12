package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.util.Date;
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
@TableName("spec_value")
@ApiModel(value="SpecValue对象", description="")
public class SpecValue extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格值")
    private String vName;

    @ApiModelProperty(value = "规格名")
    private Long specId;

    @ApiModelProperty(value = "状态(0:禁用,1:启用)")
    private Integer state;

    private Date createTime;

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }
    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
