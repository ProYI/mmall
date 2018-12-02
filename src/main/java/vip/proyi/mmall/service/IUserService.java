package vip.proyi.mmall.service;

import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.pojo.User;

/**
* 用户模块接口
*/
public interface IUserService {
    /**
    * 登录接口
    * @param username
    * @param password
    * @return
    */
    ServerResponse<User> login(String username, String password);
    /**
    * 注册接口
    * @param user
    * @return
    */
    ServerResponse<User> register(User user);
    /**
     * 检测用户名和email是否存在
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);
    /**
     * 忘记密码返回找回密码的问题
     * @param username
     * @return
     */
    ServerResponse<String> selectQuestion(String username);
    /**
     * 检查找回密码的问题答案是否正确
     * @param username
     * @return
     */
    ServerResponse<String> forgetCheckAnswer(String username, String question, String answer);
    /**
    * 忘记密码时重置密码
    * @param username
    * @param passwordNew
    * @param forgetToken
    * @return
    */
    ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken);
    /**
    * 登录状态重置密码
    * @param passwordOld
    * @param passwordNew
    * @param user
    * @return
    */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
    /**
    * 更新个人信息
    * @param user
    * @return
    */
    ServerResponse<User> updateInformation(User user);
    /**
    * 获取个人信息
    * @param userId
    * @return
    */
    ServerResponse<User> getInformation(Integer userId);
}
