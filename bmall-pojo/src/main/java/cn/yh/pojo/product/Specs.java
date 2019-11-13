package cn.yh.pojo.product;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 商品规格
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@TableName("specs")
@ApiModel(value="Specs对象", description="商品规格")
public class Specs extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类ID")
    private Long categoryId;

    private String name;

    @ApiModelProperty(value = "状态(0禁用,1启用)")
    private Integer state;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
 
}
