package com.xzsd.pc.hot.dao;

import com.xzsd.pc.hot.entity.HotGoodsInfo;
import com.xzsd.pc.hot.entity.HotGoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 热门商品
 * @author zhaorujie
 * @date 2020-3-31
 */
@Mapper
public interface HotGoodsDao {

    /**
     * 统计排序是否出现重复的序号
     * @param hotGoodsInfo
     * @return
     */
    int countSort(HotGoodsInfo hotGoodsInfo);

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门商品详情
     * @param hotId
     * @return
     */
    HotGoodsVO getHotGoodsById(@Param("hotId") String hotId);

    /**
     * 修改热门位商品
     * @param hotGoodsInfo
     * @return
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门商品列表（分页）
     * @param hotGoodsInfo
     * @return
     */
    List<HotGoodsVO> getListHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 修改热门商品展示数量
     * @param showNumber
     * @param loginId
     * @return
     */
    int modifyShowNumber(@Param("showNumber") String showNumber, @Param("loginId") String loginId);

    /**
     * 删除热门位商品
     * @param listHotId
     * @param loginId
     * @return
     */
    int deleteHotGoods(@Param("listHotId") List<String> listHotId, @Param("loginId") String loginId);
}
