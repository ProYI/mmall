/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author: ProYI
 * Date: 2018-11-29 21:44
 * Description: 用户模块
 */


package vip.proyi.mmall.controller.portal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.proyi.mmall.common.Const;
import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.pojo.User;
import vip.proyi.mmall.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * 〈用户模块〉
 * @author ProYI
 * @create 2018-11-29
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return ServerResponse<User>
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }
    /**
    * 用户登出
    * @return
    */
    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }
    /**
    * 用户注册
    * @param
    * @return
    */
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> register(User user) {
        return iUserService.register(user);
    }

    /**
    * 注册时用户名校验
    */
    public ServerResponse<String> checkValid(String str, String type) {
        return null;
    }
}