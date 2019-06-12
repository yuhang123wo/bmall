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
@TableName("attr_value")
@ApiModel(value="AttrValue对象", description="")
public class AttrValue extends Entity {

    private static final long serialVersionUID = 1L;

    private String vName;

    private Long attrId;

    @ApiModelProperty(value = "状态(0:禁用 1:启用)")
    private Integer state;

    private Date createTime;

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }
    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
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
