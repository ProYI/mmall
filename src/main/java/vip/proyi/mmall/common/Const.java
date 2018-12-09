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
}