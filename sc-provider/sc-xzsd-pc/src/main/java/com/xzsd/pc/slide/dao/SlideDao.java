package com.xzsd.pc.slide.dao;

import com.xzsd.pc.slide.entity.SlideInfo;
import com.xzsd.pc.slide.entity.SlideVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**@Description SlideDao
 * @author zhaorujie
 * @data 2020-3-29
 */
@Mapper
public interface SlideDao {
    /**
     * 统计sort出现的次数
     * @param slideInfo
     * @return
     */
    int countSort(SlideInfo slideInfo);
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
     * @param listSlideId
     * @param slideStatus
     * @param loginId
     * @return
     */
    int updateSlideStatus(@Param("listSlideId") List<String> listSlideId,
                          @Param("slideStatus") String slideStatus,
                          @Param("loginId") String loginId);

    /**
     * 删除轮播图
     * @param listSlideId
     * @param loginId
     * @return
     */
    int deleteSlide(@Param("listSlideId") List<String> listSlideId, @Param("loginId") String loginId);
}
