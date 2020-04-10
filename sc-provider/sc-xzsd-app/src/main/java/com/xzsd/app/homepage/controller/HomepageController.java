package com.xzsd.app.homepage.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.homepage.entity.HotGoods;
import com.xzsd.app.homepage.service.HomepageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 首页轮播图查询，热门位商品查询
 * @author zhaorujie
 * @date 2020/4/9
 */
@RestController
@RequestMapping("clientHome")
public class HomepageController {

    public static final Logger logger = LoggerFactory.getLogger(HomepageController.class);

    @Resource
    private HomepageService homepageService;

    /**
     * 查询首页轮播图
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    @PostMapping("listRotationCharHome")
    public AppResponse getListSlideshow(){
        try {
            return homepageService.getListSlideshow();
        }catch (Exception e){
            logger.error("查询首页轮播图失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询首页热门位商品
     *
     * @param hotGoods
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    @PostMapping("listHotGoods")
    public AppResponse getListHotGoods(HotGoods hotGoods){
        try {
            return homepageService.getListHotGoods(hotGoods);
        }catch (Exception e){
            logger.error("查询首页热门位商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
