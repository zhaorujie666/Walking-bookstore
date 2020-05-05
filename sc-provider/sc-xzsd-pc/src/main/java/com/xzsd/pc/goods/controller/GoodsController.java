package com.xzsd.pc.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查GoodsInfo
 * @author zhaorujie
 * @date 2020-03-28
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;

    /**
     * 新增商品
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateUser(userId);
            return goodsService.addGoods(goodsInfo);
        }catch (Exception e){
            logger.error("新增商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     * @param goodsId 商品id
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @PostMapping("getGoods")
    public AppResponse getGoodsInfoById(String goodsId){
        try {
            return goodsService.getGoodsInfoById(goodsId);
        }catch (Exception e){
            logger.error("查询商品详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 获取商品分类
     * @param classifyId 商品分类id
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @PostMapping("listGoodsClassify")
    public AppResponse getListGoodsCategory(String classifyId){
        try {
            return goodsService.getListGoodsCategory(classifyId);
        }catch (Exception e){
            logger.error("获取商品分类失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 更新商品信息
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoodsInfo(GoodsInfo goodsInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setUpdateUser(userId);
            return goodsService.updateGoodsInfo(goodsInfo);
        }catch (Exception e){
            logger.error("更新商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @PostMapping("updateGoodsShelfState")
    public AppResponse updateGoodsStatus(GoodsInfo goodsInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setUpdateUser(userId);
            return goodsService.updateGoodsStatus(goodsInfo);
        }catch (Exception e){
            logger.error("修改商品状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品列表（分页）
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @PostMapping("listGoods")
    public AppResponse getListGoods(GoodsInfo goodsInfo){
        try {
            return goodsService.getListGoods(goodsInfo);
        }catch (Exception e){
            logger.error("查询商品列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     * @param goodsId 商品id
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsId){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsId, userId);
        }catch (Exception e){
            logger.error("删除商品状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
