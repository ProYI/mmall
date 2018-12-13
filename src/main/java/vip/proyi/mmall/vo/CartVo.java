/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CartVo
 * Author: ProYI
 * Date: 2018-12-11 22:11
 * Description: 购物车包装类
 */


package vip.proyi.mmall.vo;


import java.math.BigDecimal;
import java.util.List;

/**
 * 〈购物车包装类〉
 * @author ProYI
 * @create 2018-12-11
 */

public class CartVo {
    private List<CartProductVo> cartProductVoList;
    private BigDecimal cartTotalPrice;
    //是否已经都勾选
    private Boolean allChecked;
    private String imageHost;

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}