package com.xzsd.app.homepage.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.homepage.dao.HomepageDao;
import com.xzsd.app.homepage.entity.HotGoods;
import com.xzsd.app.homepage.entity.HotGoodsList;
import com.xzsd.app.homepage.entity.Slideshow;
import com.xzsd.app.homepage.entity.SlideshowList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 查首页轮播图和热门位商品
 * @author zhaorujie
 * @date 2020/4/9
 */
@Service
public class HomepageService {
    @Resource
    private HomepageDao homepageDao;

    /**
     * 查询首页轮播图
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    public AppResponse getListSlideshow(){
        List<Slideshow> listSlideshow = homepageDao.getListSlideshow();
        //封装数据
        SlideshowList slideshowList = new SlideshowList();
        slideshowList.setSlideshowList(listSlideshow);
        return AppResponse.success("查询首页轮播图成功", slideshowList);
    }

    /**
     * 查询首页热门位商品
     *
     * @param hotGoods
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    public AppResponse getListHotGoods(HotGoods hotGoods){
        //获取热门位商品展示数量
        int number = homepageDao.getSlideshowNumber();
        if(0 == number){
            return AppResponse.success("查询热门位商品成功", null);
        }
        hotGoods.setShowNumber(number);
        List<HotGoods> listHotGoods = homepageDao.getListHotGoods(hotGoods);
        //封装数据
        HotGoodsList list = new HotGoodsList();
        list.setList(listHotGoods);
        return AppResponse.success("查询热门位商品成功", list);
    }
}
