package com.xzsd.pc.goods.dao;

import com.xzsd.pc.category.entity.GoodsCategoryVO;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsVO;
import com.xzsd.pc.goods.entity.GoodsVTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description Goods
 * @Author zhaorujie
 * @Date 2020-03-28
 */
@Mapper
public interface GoodsDao {

    /**
     * 统计是否出现重复的书号个数
     * @param isbn
     * @return
     */
    int countBookNumber(@Param("isbn") String isbn);

    /**
     * 新增商品
     * @param goodsInfo
     * @return
     */
    int addGoods(GoodsInfo goodsInfo);

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     */
    GoodsVTO getGoodsInfoById(@Param("goodsId") String goodsId);

    /**
     * 查询商品一二级分类名称
     * @param goodsId
     * @return
     */
    List<String> getGoodsCategoryName(@Param("goodsId") String goodsId);

    /**
     * 查询商品一二级分类列表
     * @param classifyId
     * @return
     */
    List<GoodsCategoryVO> getListGoodsCategory(@Param("classifyId") String classifyId);

    /**
     * 修改商品的信息
     * @param goodsInfo
     * @return
     */
    int updateGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 查询商品列表（分页）
     * @param goodsInfo
     * @return
     */
    List<GoodsVO> getListGoods(GoodsInfo goodsInfo);

    /**
     * 修改商品状态
     * @param listGoodsId
     * @param goodsStateId
     * @param loginId
     * @return
     */
    int updateGoodsStatus(@Param("listGoodsId") List<String> listGoodsId,
                          @Param("goodsStateId") String goodsStateId,
                          @Param("loginId") String loginId);

    /**
     * 删除商品
     * @param listGoodsId
     * @param loginId
     * @return
     */
    int deleteGoods(@Param("listGoodsId") List<String> listGoodsId, @Param("loginId") String loginId);

}
