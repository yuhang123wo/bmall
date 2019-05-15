package cn.yh.pojo.order;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
@TableName("order_detail")
@ApiModel(value="OrderDetail对象", description="订单详情表")
public class OrderDetail extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单表ID")
    private Long orderId;

    @ApiModelProperty(value = "订单商品ID")
    private Long productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "购买商品数量")
    private Integer quantity;

    @ApiModelProperty(value = "购买商品单价")
    private BigDecimal price;

    @ApiModelProperty(value = "商品重量")
    private BigDecimal weight;

    @ApiModelProperty(value = "仓库ID")
    private Long skuId;

    @ApiModelProperty(value = "最后修改时间")
    private Date updateTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
