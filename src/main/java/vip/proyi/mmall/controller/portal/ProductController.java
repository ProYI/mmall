/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductController
 * Author: ProYI
 * Date: 2018-12-09 18:34
 * Description: 前台用户商品转发
 */


package vip.proyi.mmall.controller.portal;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.service.IProductService;
import vip.proyi.mmall.vo.ProductDetailVo;

/**
 * 〈前台商品转发〉
 * @author ProYI
 * @create 2018-12-09
 */
@Controller
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    /**
    * 前台获取商品详情
    * @param productId
    * @return
    */
    @RequestMapping(value = "detail.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<ProductDetailVo> getDetail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    /**
    * 商品列表
    * @param
    * @return
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> productList(@RequestParam(value = "keyword", required = false) String keyword,
                                                @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }

}