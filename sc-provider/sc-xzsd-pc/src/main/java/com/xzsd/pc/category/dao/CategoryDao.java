package com.xzsd.pc.category.dao;

import com.xzsd.pc.category.entity.GoodsCategory;
import com.xzsd.pc.category.entity.GoodsCategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName goodsCategoryDao
 * @Description goodsCategory
 * @Author zhaorujie
 * @Date 2020-03-26
 */
@Mapper
public interface CategoryDao {
    /**
     * 统计商品分类的名称
     * @param goodsCategory
     * @return
     */
    int countGoodsCategoryName(GoodsCategory goodsCategory);
    /**
     * 新增商品分类
     * @param goodsCategory
     * @return
     */
    int addGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 查询分类详情
     * @param classifyId
     * @return
     */
    GoodsCategoryVO getGoodsCategoryById(@Param("classifyId") String classifyId);

    /**
     * 修改商品分类信息
     * @param goodsCategory
     * @return
     */
    int updateGoodsCategoryById(GoodsCategory goodsCategory);

    /**
     * 查询商品一二级分类列表信息
     * @return
     */
    List<GoodsCategoryVO> getListFirstAndSecondGoodsCategory();

    /**
     * 删除商品分类
     * @param classifyId
     * @param loginId
     * @return
     */
    int deleteGoodsCategory(@Param("classifyId") String classifyId, @Param("loginId") String loginId);

    /**
     * 获取当前分类的父级id
     * @param classifyId
     * @return
     */
    int countParentId(@Param("classifyId") String classifyId);

}
