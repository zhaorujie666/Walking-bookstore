package com.xzsd.pc.slide.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.slide.entity.SlideInfo;
import com.xzsd.pc.slide.service.SlideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 增删改查
 * @author zhaorujie
 * @date 2020-3-29
 */
@RestController
@RequestMapping("/slideshowHome")
public class SlideController {

    private static final Logger logger = LoggerFactory.getLogger(SlideController.class);

    @Resource
    private SlideService slideService;


    /**
     * 新增轮播图
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @PostMapping("addSlideshowHome")
    public AppResponse addSlide(SlideInfo slideInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            slideInfo.setCreateUser(userId);
            return slideService.addSlide(slideInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图列表（分页）
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @PostMapping("listSlideshowHome")
    public AppResponse getListSlide(SlideInfo slideInfo){
        try {
            return slideService.getListSlide(slideInfo);
        }catch (Exception e){
            logger.error("查询轮播图列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改轮播图状态
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @PostMapping("updateSlideshowHomeState")
    public AppResponse updateSlideStatus(SlideInfo slideInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            slideInfo.setUpdateUser(userId);
            return slideService.updateSlideStatus(slideInfo);
        }catch (Exception e){
            logger.error("修改轮播图状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * @param slideshowId
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @PostMapping("deleteSlideshowHome")
    public AppResponse deleteSlide(String slideshowId){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            return slideService.deleteSlide(slideshowId, userId);
        }catch (Exception e){
            logger.error("删除失败！");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增轮播图和热门商品时的商品列表
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @Date 2020-03-31
     */
    @PostMapping("listGoods")
    public AppResponse getSlideAndHotGoods(GoodsInfo goodsInfo){
        try {
            return slideService.getSlideAndHotGoods(goodsInfo);
        }catch (Exception e){
            logger.error("查询新增轮播图和热门商品时的商品列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
