/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CategoryServiceImpl
 * Author: ProYI
 * Date: 2018-12-04 22:23
 * Description: 分类管理逻辑
 */


package vip.proyi.mmall.service.impl;


import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vip.proyi.mmall.common.ServerResponse;
import vip.proyi.mmall.dao.CategoryMapper;
import vip.proyi.mmall.pojo.Category;
import vip.proyi.mmall.service.ICategoryService;

import java.util.List;
import java.util.Set;

/**
 * 〈分类管理逻辑〉
 * @author ProYI
 * @create 2018-12-04
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {
    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    /**
    * 添加商品类别
    * @param categoryName
    * @param parentId
    * @return
    */
    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if (parentId==null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("添加品类参数错误");
        }

        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        /**
        * 分类是可用的
        */
        category.setStatus(true);

        int rowCount = categoryMapper.insert(category);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("添加品类成功");
        }
        return ServerResponse.createByErrorMessage("添加品类失败");
    }
    /**
    * 更新categoryName
    * @param categoryId
    * @param categoryName
    * @return
    */
    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        if (categoryId == null && StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("更新品类的参数错误");
        }

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("更新品类名称成功");
        }
        return ServerResponse.createByErrorMessage("更新品类名称失败");
    }

    /**
    * 根据传入的categoryId获取当前子节点的平行节点（同一层级）的category信息
    * @param categoryId
    * @return
    */
    @Override
    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        if (CollectionUtils.isEmpty(categoryList)) {
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

    /**
    * 递归查询本节点的Id及子节点的Id
    * @param categoryId
    * @return
    */
    @Override
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId) {
        //guava提供的初始化set集合方法
        Set<Category> categorySet = Sets.newHashSet();
        findChildCategory(categorySet, categoryId);

        List<Integer> categoryIdList = Lists.newArrayList();
        if (categoryId != null) {
            for (Category categoryItem : categorySet) {
                categoryIdList.add(categoryItem.getId());
            }
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }
    /**
    * 递归算法算出子节点
    * @param
    * @return
    */
    private Set<Category> findChildCategory(Set<Category> categorySet, Integer categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category != null) {
            categorySet.add(category);
        }
        //查找子节点，递归算法一定要有一个退出条件
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for (Category categoryItem : categoryList) {
            findChildCategory(categorySet, categoryItem.getId());
        }
        return categorySet;
    }
}