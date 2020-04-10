package com.xzsd.pc.slide.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.slide.entity.SlideInfo;
import com.xzsd.pc.slide.service.SlideService;
import com.xzsd.pc.util.AppResponse;
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
@RequestMapping("/slide")
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
    @PostMapping("/addSlide")
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
    @PostMapping("/listSlide")
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
     * @param slideId
     * @param slideStatus
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @PostMapping("/updateGoodsStatusById")
    public AppResponse updateSlideStatus(String slideId,
                                         String slideStatus){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            return slideService.updateSlideStatus(slideId, slideStatus, userId);
        }catch (Exception e){
            logger.error("修改轮播图状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * @param slideId
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @PostMapping("/deleteSlide")
    public AppResponse deleteSlide(String slideId){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            return slideService.deleteSlide(slideId, userId);
        }catch (Exception e){
            logger.error("删除失败！");
            System.out.println(e.toString());
            throw e;
        }
    }
}
