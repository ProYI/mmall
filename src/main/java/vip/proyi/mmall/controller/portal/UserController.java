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
import vip.proyi.mmall.common.ResponseCode;
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
    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
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
    @RequestMapping(value = "checkvalid.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }

    /**
    * 获取用户登录信息
    * @param session
    * @return
    */
    @RequestMapping(value = "getuserinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
    }
    /**
    * 忘记密码
    * 忘记密码返回密保问题
    * @param
    * @return
    */
    @RequestMapping(value = "forgetgetquestion.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username) {
        return iUserService.selectQuestion(username);
    }

    /**
    * 检查找回密码问题答案是否正确
    */
    @RequestMapping(value = "forgetcheckanswer.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
        return iUserService.forgetCheckAnswer(username, question, answer);
    }
    /**
    * 忘记密码中的重置密码
    * @param username
    * @param passwordNew
    * @param forgetToken
    * @return
    */
    @RequestMapping(value = "forgetrestpassword.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken) {
        return iUserService.forgetRestPassword(username, passwordNew, forgetToken);
    }
    /**
    * 登录状态的重置密码
    * @param session
    * @param passwordOld
    * @param passwordNew
    * @return
    */
    @RequestMapping(value = "resetpassword.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld, passwordNew, user);
    }
    /**
    * 更新个人信息
    * @param
    * @return
    */
    @RequestMapping(value = "updateinformation.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> updateInformation(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        //前端传过来的user映射对象没有userId，从当前登录用户中获取到userId 用户名不能被更新，也需要获取
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }
    /**
    * 获取用户的详细信息
    * @param
    * @return
    */
    @RequestMapping(value = "getinformation.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getInformation(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录，需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }
}