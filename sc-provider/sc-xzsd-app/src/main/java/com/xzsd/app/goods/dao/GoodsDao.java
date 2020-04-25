package com.xzsd.app.goods.dao;

import com.xzsd.app.goods.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @author zhaorujie
 * @date 2020/4/12
 */
public interface GoodsDao {
    /**
     * 查询商品详情
     * @param goodsId
     * @return
     */
    GoodsInfo getGoodsInfoById(@Param("goodsId") String goodsId);

    /**
     * 更新商品浏览量
     * @param goodsId
     * @return
     */
    int updateGoodsViewNumber(@Param("goodsId") String goodsId);

    /**
     * 查询商品评价列表
     * @param goodsEvaluation
     * @return
     */
    List<GoodsEvaluationVO> getListGoodsEvaluation(GoodsEvaluation goodsEvaluation);

    /**
     * 查询每个评价商品的所有图片
     * @param goodsEvaluation
     * @return
     */
    List<EvaluationImage> getListGoodsImage(GoodsEvaluation goodsEvaluation);

    /**
     * 查询商品一级分类
     * @return
     */
    List<GoodsCategory> getFirstGoodsCategory();

    /**
     * 查询商品二级分类级商品信息
     * @param classifyId
     * @return
     */
    List<GoodsCategory> getSecondGoodsCategory(@Param("classifyId") String classifyId);

    /**
     * 查询二级分类下的商品
     * @param classifyId
     * @return
     */
    List<GoodsInfo> getGoodsList(@Param("classifyId") String classifyId);
}
