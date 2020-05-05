package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsShowNumber;
import com.xzsd.pc.hotgoods.entity.HotGoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 热门商品Dao层
 * @author zhaorujie
 * @date 2020-3-31
 */
@Mapper
public interface HotGoodsDao {
    /**
     * 统计排序和商品是否存在
     * @param hotGoodsInfo
     * @return
     */
    int countSortAndGoodsIsUse(HotGoodsInfo hotGoodsInfo);

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门商品详情
     * @param hotGoodsId
     * @return
     */
    HotGoodsVO getHotGoodsById(@Param("hotGoodsId") String hotGoodsId);

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
     * 查询热门位商品展示数量
     * @return
     */
    HotGoodsShowNumber getHotGoodsShowNumber();

    /**
     * 修改热门商品展示数量
     * @param hotGoodsShowNumber
     * @return
     */
    int modifyShowNumber(HotGoodsShowNumber hotGoodsShowNumber);

    /**
     * 删除热门位商品
     * @param listHotId
     * @param loginId
     * @return
     */
    int deleteHotGoods(@Param("listHotId") List<String> listHotId, @Param("loginId") String loginId);
}
