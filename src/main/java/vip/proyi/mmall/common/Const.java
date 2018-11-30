/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Const
 * Author: ProYI
 * Date: 2018-11-30 0:15
 * Description: 常量类
 */


package vip.proyi.mmall.common;


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
}