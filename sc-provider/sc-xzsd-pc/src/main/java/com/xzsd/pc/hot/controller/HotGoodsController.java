package com.xzsd.pc.hot.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hot.entity.HotGoodsInfo;
import com.xzsd.pc.hot.service.HotGoodsService;
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
 * @date 2020-3-31
 */
@RestController
@RequestMapping("/goodsHot")
public class HotGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("/addGoodsHot")
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateUser(userId);
            return hotGoodsService.addHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("新增热门商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品详情
     * @param hotId
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("/findGoodsHotById")
    public AppResponse getHotGoodsById(String hotId){
        try {
            return hotGoodsService.getHotGoodsById(hotId);
        }catch (Exception e){
            logger.error("查询热门商品详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品信息
     * @param hotGoodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("/updateUserById")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setUpdateUser(userId);
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("修改热门商品信息失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表（分页）
     * @param hotGoodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("/listGoodsHot")
    public AppResponse getListHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.getListHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("查询热门商品列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门位商品展示数量
     * @param showNumber
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("/showNumber")
    public AppResponse modifyShowNumber(String showNumber, String userId){
        try {
            return hotGoodsService.modifyShowNumber(showNumber, userId);
        }catch (Exception e){
            logger.error("修改热门位商品展示数量失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门位商品
     * @param hotId
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("/deleteGoodsHot")
    public AppResponse deleteHotGoods(String hotId, String userId){
        try {
            return hotGoodsService.deleteHotGoods(hotId, userId);
        }catch (Exception e){
            logger.error("删除热门位商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
