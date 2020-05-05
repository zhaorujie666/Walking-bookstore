package com.xzsd.pc.slide.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.slide.entity.SlideAndHotGoods;
import com.xzsd.pc.slide.entity.SlideInfo;
import com.xzsd.pc.slide.entity.SlideVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**@Description SlideDao 轮播图Dao层
 * @author zhaorujie
 * @data 2020-3-29
 */
@Mapper
public interface SlideDao {
    /**
     * 统计排序否存在和商品是否已经被使用
     * @param slideInfo
     * @return
     */
    int countSortAndGoodsIsUse(SlideInfo slideInfo);

    /**
     * 新增轮播图
     * @param slideInfo
     * @return
     */
    int addSlide(SlideInfo slideInfo);

    /**
     * 查询轮播图列表
     * @param slideInfo
     * @return
     */
    List<SlideVO> getListSlide(SlideInfo slideInfo);

    /**
     * 修改轮播图状态
     * @param slideInfoList
     * @return
     */
    int updateSlideStatus(@Param("slideInfoList") List<SlideInfo> slideInfoList);

    /**
     * 删除轮播图
     * @param listSlideId
     * @param loginId
     * @return
     */
    int deleteSlide(@Param("listSlideId") List<String> listSlideId, @Param("loginId") String loginId);

    /**
     * 新增轮播图和热门商品时的商品列表
     * @param goodsInfo
     * @return
     */
    List<SlideAndHotGoods> getSlideAndHotGoods(GoodsInfo goodsInfo);
}
