package vip.proyi.mmall.service;

import com.github.pagehelper.PageInfo;
import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.pojo.Product;
import vip.proyi.mmall.vo.ProductDetailVo;

public interface IProductService {
    /**
     * 保存或更新产品
     * 此接口可以合二为一，当然要经过判断
     * @param product
     * @return
     */
    ServerResponse saveOrUpdateProduct(Product product);
    /**
     * 更新产品销售状态（上架或下架）
     * @param productId
     * @param status
     * @return
     */
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
    /**
     * 获取商品详情
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
    /**
     * 后台商品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize);
    /**
     * 后台商品搜索
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, Integer pageNum, Integer pageSize);
    /**
     * 前台商品详情
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);
    /**
     * 前台商品列表
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, Integer pageNum, Integer pageSize, String orderBy);
}
