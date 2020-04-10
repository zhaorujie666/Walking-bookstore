package com.xzsd.pc.category.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.category.entity.GoodsCategory;
import com.xzsd.pc.category.service.CategoryService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查goodsCategory
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryService categoryService;


    /**
     * 新增商品分类
     * @param goodsCategory
     * @return
     * @author zhaorujie
     * @Date 2020-03-26
     */
    @PostMapping("addGoodsCategory")
    public AppResponse addGoodsCategory(GoodsCategory goodsCategory){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return categoryService.addGoodsCategory(goodsCategory, userId);
        }catch (Exception e){
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类详情
     * @param categoryId
     * @return
     * @author zhaorujie
     * @Date 2020-03-26
     */
    @PostMapping("findCategoryById")
    public AppResponse getGoodsCategoryById(String categoryId){
        try {
            return categoryService.getGoodsCategoryById(categoryId);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品分类信息
     * @param goodsCategory
     * @return
     * @author zhaorujie
     * @Date 2020-03-26
     */
    @PostMapping("updateCategoryById")
    public AppResponse updateGoodsCategoryById(GoodsCategory goodsCategory){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return categoryService.updateGoodsCategoryById(goodsCategory, userId);
        }catch (Exception e){
            logger.error("修改成功", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类列表
     * @return
     * @author zhaorujie
     * @Date 2020-03-26
     */
    @PostMapping("listCategory")
    public AppResponse getListGoodsCategory(){
        try {
            return categoryService.getListGoodsCategory();
        }catch (Exception e){
            logger.error("查询成功", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     * @param categoryId
     * @return
     * @author zhaorujie
     * @Date 2020-03-27
     */
    @PostMapping("deleteCategory")
    public AppResponse deleteGoodsCategory(String categoryId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return categoryService.deleteGoodsCategory(categoryId, userId);
        } catch (Exception e) {
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
