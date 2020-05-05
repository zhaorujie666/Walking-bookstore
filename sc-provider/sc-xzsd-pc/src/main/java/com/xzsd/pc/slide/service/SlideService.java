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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 轮播图的实现类
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
        //校验排序是否重复和商品是否已经被选择
        int count = slideDao.countSortAndGoodsIsUse(slideInfo);
        if(count == 1){
            return AppResponse.versionError("出现重复的排序，请重新输入！");
        }
        if(count == 2){
            return AppResponse.versionError("该商品已经被选择，请重新选择");
        }
        if(count == 3){
            return AppResponse.versionError("出现重复的排序和该商品已经被选择，请重新选择");
        }
        slideInfo.setSlideshowId(StringUtil.getCommonCode(2));
        int num = slideDao.addSlide(slideInfo);
        if(num == 0){
            return AppResponse.versionError("新增轮播图失败！");
        }
        return AppResponse.success("新增轮播图成功！");
    }

    /**
     * 修改轮播图状态
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideStatus(SlideInfo slideInfo){
        List<String> listSlideId = Arrays.asList(slideInfo.getSlideshowId().split(","));
        List<String> listVersion = Arrays.asList(slideInfo.getVersion().split(","));
        List<SlideInfo> slideInfoList = new ArrayList<>();
        for (int i = 0; i < listSlideId.size() && i < listVersion.size(); i++) {
            SlideInfo info = new SlideInfo();
            //设置轮播图id
            info.setSlideshowId(listSlideId.get(i));
            //设置轮播图版本号
            info.setVersion(listVersion.get(i));
            //设置轮播图状态
            info.setSlideshowStateId(slideInfo.getSlideshowStateId());
            //设置更新人
            info.setUpdateUser(slideInfo.getUpdateUser());
            slideInfoList.add(info);
        }
        int count = slideDao.updateSlideStatus(slideInfoList);
        if(count == 0){
            return AppResponse.versionError("修改轮播图状态失败！");
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
            return AppResponse.versionError("删除轮播图失败！");
        }
        return AppResponse.success("删除轮播图成功！");
    }

    /**
     * 新增轮播图和热门商品时的商品列表
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-29
     */
    public AppResponse getSlideAndHotGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<SlideAndHotGoods> slideAndHotGoods = slideDao.getSlideAndHotGoods(goodsInfo);
        PageInfo<SlideAndHotGoods> pageData = new PageInfo<>(slideAndHotGoods);
        return AppResponse.success("查询成功！", pageData);
    }
}
