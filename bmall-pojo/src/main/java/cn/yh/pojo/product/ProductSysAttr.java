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
@TableName("product_sys_attr")
@ApiModel(value="ProductSysAttr对象", description="")
public class ProductSysAttr extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品类别编号")
    private Integer categoryId;

    @ApiModelProperty(value = "属性名称")
    private String name;

    @ApiModelProperty(value = "排列次序")
    private Integer sort;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
}
