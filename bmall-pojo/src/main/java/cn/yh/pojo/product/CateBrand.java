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
 * @since 2019-07-16
 */
@TableName("cate_brand")
@ApiModel(value="CateBrand对象", description="")
public class CateBrand extends Entity {

    private static final long serialVersionUID = 1L;

    private Long brandId;

    private Long categoryId;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "CateBrand{" +
        "brandId=" + brandId +
        ", categoryId=" + categoryId +
        "}";
    }
}
