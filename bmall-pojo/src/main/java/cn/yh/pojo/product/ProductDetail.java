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
@TableName("product_detail")
@ApiModel(value="Detail对象", description="")
public class ProductDetail extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "详情图片json")
    private String imgs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

}
