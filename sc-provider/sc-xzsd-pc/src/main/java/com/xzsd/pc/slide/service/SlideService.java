package com.xzsd.pc.slide.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.slide.dao.SlideDao;
import com.xzsd.pc.slide.entity.SlideAndHotGoods;
import com.xzsd.pc.slide.entity.SlideInfo;
import com.xzsd.pc.slide.entity.SlideVO;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 实现类
 * @author zhaorujie
 * @date 2020-3-29
 */
@Service
public class SlideService {

    @Resource
    private SlideDao slideDao;

    /**
     * 新增轮播图·
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSlide(SlideInfo slideInfo){
        //校验是否存在相同的排序
        int countSort = slideDao.countSort(slideInfo);
        if(countSort != 0){
            return AppResponse.bizError("出现重复的排序或当前的商品已被选择，请重新输入！");
        }
        slideInfo.setSlideshowId(StringUtil.getCommonCode(2));
        int count = slideDao.addSlide(slideInfo);
        if(count == 0){
            return AppResponse.bizError("新增轮播图失败！");
        }
        return AppResponse.success("新增轮播图成功！");
    }

    /**
     * 修改轮播图状态
     * @param slideshowId
     * @param slideshowStateId
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideStatus(String slideshowId,
                                         String slideshowStateId,
                                         String userId){
        List<String> listSlideId = Arrays.asList(slideshowId.split(","));
        int count = slideDao.updateSlideStatus(listSlideId, slideshowStateId, userId);
        if(count == 0){
            return AppResponse.bizError("修改轮播图状态失败！");
        }
        return AppResponse.success("修改轮播图状态成功！");
    }

    /**
     * 查询轮播图列表（分页）
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    public AppResponse getListSlide(SlideInfo slideInfo){
        PageHelper.startPage(slideInfo.getPageNum(), slideInfo.getPageSize());
        List<SlideVO> listSlide = slideDao.getListSlide(slideInfo);
        PageInfo<SlideVO> pageData = new PageInfo<>(listSlide);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除轮播图
     * @param slideshowId
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSlide(String slideshowId, String userId){
        List<String> listSlideId = Arrays.asList(slideshowId.split(","));
        int count = slideDao.deleteSlide(listSlideId, userId);
        if(count == 0){
            return AppResponse.bizError("删除轮播图失败！");
        }
        return AppResponse.success("删除轮播图成功！");
    }

    /**
     * 新增轮播图和热门商品时的商品列表
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @Date 2020-03-29
     */
    public AppResponse getSlideAndHotGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<SlideAndHotGoods> slideAndHotGoods = slideDao.getSlideAndHotGoods(goodsInfo);
        PageInfo<SlideAndHotGoods> pageData = new PageInfo<>(slideAndHotGoods);
        return AppResponse.success("查询成功！", pageData);
    }
}
