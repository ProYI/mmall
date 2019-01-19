/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderProductVo
 * Author: ProYI
 * Date: 2019-01-19 16:46
 * Description: 订单商品
 */


package vip.proyi.mmall.vo;


import java.math.BigDecimal;
import java.util.List;

/**
 * 〈订单中选中商品〉
 * @author ProYI
 * @create 2019-01-19
 */

public class OrderProductVo {
    private List<OrderItemVo> orderItemVoList;
    private BigDecimal productTotalPrice;
    private String imageHost;

    public List<OrderItemVo> getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}