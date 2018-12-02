/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserManageController
 * Author: ProYI
 * Date: 2018-12-02 21:22
 * Description: 后台管理用户controller
 */


package vip.proyi.mmall.controller.backend;


import org.springframework.beans.factory.annotation.Autowired;
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
 * 〈后台管理用户controller〉
 * @author ProYI
 * @create 2018-12-02
 */
@Controller
@RequestMapping("/manage/user/")
public class UserManageController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse response = iUserService.login(username, password);
        if (response.isSuccess()) {
            User user = (User) response.getData();
            if (user.getRole() == Const.Role.Role_ADMIN) {
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER, user);
                return response;
            } else {
                return ServerResponse.createByErrorMessage("该账户不是管理员账户");
            }
        }
        return response;
    }

}