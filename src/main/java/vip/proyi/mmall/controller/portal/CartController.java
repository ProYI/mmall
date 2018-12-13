/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CartController
 * Author: ProYI
 * Date: 2018-12-10 23:21
 * Description: 购物车
 */


package vip.proyi.mmall.controller.portal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.proyi.mmall.common.Const;
import vip.proyi.mmall.common.ResponseCode;
import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.pojo.User;
import vip.proyi.mmall.service.ICartService;
import vip.proyi.mmall.vo.CartVo;

import javax.servlet.http.HttpSession;

/**
 * 〈购物车〉
 * @author ProYI
 * @create 2018-12-10
 */
@Controller
@RequestMapping("/cart/")
public class CartController {
    @Autowired
    private ICartService iCartService;

    /**
     * 向购物车中添加商品
     * @param session
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.add(user.getId(), productId, count);
    }

    /**
     * 更新购物车
     * @param session
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<CartVo> update(HttpSession session, Integer count, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.update(user.getId(), productId, count);
    }
    /**
    * 删除购物车中商品
    * @param session
    * @param productIds
    * @return
    */
    @RequestMapping(value = "deleteproduct.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(HttpSession session, String productIds) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.deleteProduct(user.getId(), productIds);
    }
    /**
     * 查询购物车中商品集合
     * @param session
     * @return
     */
    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.list(user.getId());
    }
    /**
    * 实现购物车中商品全选
    * @param session
    * @return
    */
    @RequestMapping(value = "selectall.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), null, Const.Cart.CHECKED);
    }
    /**
     * 实现购物车中商品全反选
     * @param session
     * @return
     */
    @RequestMapping(value = "unselectall.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), null, Const.Cart.UN_CHECKED);
    }

    /**
     * 实现购物车中商品单选
     * @param session
     * @param productId
     * @return
     */
    @RequestMapping(value = "select.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<CartVo> electAll(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), productId, Const.Cart.UN_CHECKED);
    }

    /**
     * 实现购物车中商品单选反选
     * @param session
     * @param productId
     * @return
     */
    @RequestMapping(value = "unselect.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<CartVo> unSelect(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), productId, Const.Cart.UN_CHECKED);
    }

    /**
    * 获取当前用户购物车中的产品数量
    * @param
    * @return
    */
    @RequestMapping(value = "getcartproductcount.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }
}