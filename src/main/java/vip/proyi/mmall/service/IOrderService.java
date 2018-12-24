package vip.proyi.mmall.service;

import vip.proyi.mmall.common.ServerResponse;

import java.util.Map;

public interface IOrderService {
    /**
     * 订单支付
     * @param userId
     * @param orderNo
     * @param path
     * @return
     */
    ServerResponse pay(Integer userId, Long orderNo, String path);
    /**
    * 支付宝回调信息处理
    * @param params
    * @return
    */
    ServerResponse aliCallback(Map<String, String> params);
    /**
     * 轮询查询订单的支付状态
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
}
