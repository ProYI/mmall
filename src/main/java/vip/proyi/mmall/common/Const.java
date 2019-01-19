/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Const
 * Author: ProYI
 * Date: 2018-11-30 0:15
 * Description: 常量类
 */


package vip.proyi.mmall.common;


import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 〈常量类〉
 * @author ProYI
 * @create 2018-11-30
 */

public class Const {
    /**
     * 当前用户
     */
    public static final String CURRENT_USER = "currentUser";
    /**
    * 用户分组
    */
    public interface Role {
        int Role_CUSTOMER = 0; //普通用户
        int Role_ADMIN = 1; //管理员
    }
    /**
     * 用户名分类 用户名还是email
     */
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    /**
     * 商品在售状态
     */
    public enum ProductStatusEnum {
        ON_SALE(1, "在线");


        private String value;
        private int code;

        ProductStatusEnum(int code, String value) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }
    /**
     * 商品动态排序
     */
    public interface ProductListOrderBy {
        Set<String> PRICE_ACE_DESC = Sets.newHashSet("price_desc", "price_asc");
    }
    /**
     * 购物车选中状态
     */
    public interface Cart {
        /**
        * 即购物车里商品选中状态为1
        * 未选中状态为0
        */
        int CHECKED = 1;
        int UN_CHECKED = 0;

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    /**
    * 订单状态
    */
    public enum OrderStatusEnum {
        CANCELED(0, "已取消"),
        NO_PAY(10, "未支付"),
        PAID(20, "已付款"),
        SHIPPED(40, "已发货"),
        ORDER_SUCCESS(50, "订单完成"),
        ORDER_CLOSE(60, "订单关闭");

        private String value;
        private int code;

        OrderStatusEnum(int code, String value) {
            this.value = value;
            this.code = code;
        }

        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode() == code) {
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    /**
    * 支付宝交易状态
    */
    public interface AlipayCallback {
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    /**
    * 支付渠道
    */
    public enum PayPlatformEnum {
        ALIPAY(1, "支付宝");

        private String value;
        private int code;

        PayPlatformEnum(int code, String value) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PaymentTypeEnum {
        ONLINE_PAY(1, "在线支付");

        private int code;
        private String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        PaymentTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public static PaymentTypeEnum codeOf(int code) {
            for (PaymentTypeEnum paymentTypeEnum : values()) {
                if (paymentTypeEnum.getCode() == code) {
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }


}