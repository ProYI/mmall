package vip.proyi.mmall.service;

import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    /**
     * 添加商品类别
     * @param categoryName
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);
    /**
     * 更新categoryName
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    /**
     * 根据传入的categoryId获取当前子节点的平行节点（同一层级）的category信息
     * @param categoryId
     * @return
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    /**
     * 递归查询本节点的Id及子节点的Id
     * @param categoryId
     * @return
     */
    ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}
