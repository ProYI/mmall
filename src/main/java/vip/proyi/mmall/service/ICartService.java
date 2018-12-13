package vip.proyi.mmall.service;

import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.vo.CartVo;

public interface ICartService {
    /**
     * 向购物车中添加商品
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
    /**
     * 更新购物车
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
    /**
     * 删除购物车中商品
     * @param userId
     * @param productIds
     * @return
     */
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);
    /**
     * 查询购物车中商品集合
     * @param userId
     * @return
     */
    ServerResponse<CartVo> list(Integer userId);
    /**
     * 实现购物车商品商品的选择 全选、全反选、单选
     * @param userId
     * @param productId
     * @param checked
     * @return
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);
    /**
     * 获取当前用户购物车中的产品数量
     * @param userId
     * @return
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
