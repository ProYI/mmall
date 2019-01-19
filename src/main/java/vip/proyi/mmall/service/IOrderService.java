package vip.proyi.mmall.service;

import com.github.pagehelper.PageInfo;
import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.vo.OrderVo;

import java.util.Map;

public interface IOrderService {
    /**
     * 后台发货
     * @param orderNo
     * @return
     */
    ServerResponse<String> manageSendGoods(Long orderNo);
    /**
     * 后台根据订单号等条件搜索
     * @param orderNo
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo, Integer pageNum, Integer pageSize);
    /**
     * 后台获取订单详情
     * @param orderNo
     * @return
     */
    ServerResponse<OrderVo> manageDetail(Long orderNo);
    /**
    * 后台获取订单列表
    * @param pageNum
    * @param pageSize
    * @return
    */
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);
    /**
    * 获取订单列表
    * @param userId
    * @param pageNum
    * @param pageSize
    * @return
    */
    ServerResponse<PageInfo> getOrderList(Integer userId, Integer pageNum, Integer pageSize);
    /**
     * 获取订单详情
     * @param userId
     * @param orderNo
     * @return
     */
    public ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);
    /**
    * 获取购物车中已经选中的商品详情
    * @param userId
    * @return
    */
    ServerResponse getOrderCartProduct(Integer userId);
    /**
    * 取消订单
    * @param userId
    * @param orderNo
    * @return
    */
    ServerResponse<String> cancelOrder(Integer userId, Long orderNo);
    /**
    * 新建订单
    * @param userId
    * @param shippingId
    * @return
    */
    ServerResponse createOrder(Integer userId, Integer shippingId);
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
