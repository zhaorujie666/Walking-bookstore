package com.xzsd.app.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.entity.GoodsEvaluation;
import com.xzsd.app.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查
 * @author zhaorujie
 * @date 2020/4/12
 */
@RestController
@RequestMapping("/clientGoods")
public class GoodsController {
    public static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("getGoods")
    public AppResponse getGoodsInfoById(String goodsId){
        try {
            return goodsService.getGoodsInfoById(goodsId);
        }catch (Exception e){
            logger.error("查询商品详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品评价
     * @param goodsEvaluation
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("listGoodsEvaluates")
    public AppResponse getListGoodsEvaluation(GoodsEvaluation goodsEvaluation){
        try {
            return goodsService.getListGoodsEvaluation(goodsEvaluation);
        }catch (Exception e){
            logger.error("查询商品评价失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品一级分类
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("listOneGoodsClassify")
    public AppResponse getFirstGoodsCategory(){
        try {
            return goodsService.getFirstGoodsCategory();
        }catch (Exception e){
            logger.error("查询商品一级分类失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品二级分类及商品
     * @param classifyId
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("listGetClassGoods")
    public AppResponse getSecondGoodsCategory(String classifyId){
        try {
            return goodsService.getSecondGoodsCategory(classifyId);
        }catch (Exception e){
            logger.error("查询商品二级分类及商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
