package cn.yh.pojo.product;

import java.util.Date;

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
@TableName("category")
@ApiModel(value="Category对象", description="")
public class Category extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类名")
    private String categoryName;

    @ApiModelProperty(value = "父ID")
    private Long pId;

    @ApiModelProperty(value = "状态(0:无效，1：有效)")
    private Integer state;

    private Date updateTime;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
