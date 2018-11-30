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
    * @param
    * @return
    */
    ServerResponse<User> register(User user);
}
