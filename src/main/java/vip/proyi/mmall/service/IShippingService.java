package vip.proyi.mmall.service;

import com.github.pagehelper.PageInfo;
import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.pojo.Shipping;

public interface IShippingService {
    /**
     * 新建收货地址
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse add(Integer userId, Shipping shipping);
    /**
     * 删除收货地址
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse del(Integer userId, Integer shippingId);
    /**
     * 更新收货地址
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse update(Integer userId, Shipping shipping);
    /**
     * 查询收货地址详情
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    /**
     * 查询收货地址列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
