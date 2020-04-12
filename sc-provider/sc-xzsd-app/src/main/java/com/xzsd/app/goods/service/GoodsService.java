package com.xzsd.app.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Descriptiom 商品业务逻辑
 * @author zhaorujie
 * @data 2020/4/12
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return
     * @author zhaorujie
     * @data 2020/4/12
     */
    public AppResponse getGoodsInfoById(String goodsId){
        GoodsInfo goodsInfo = goodsDao.getGoodsInfoById(goodsId);
        if(null == goodsInfo){
            return AppResponse.bizError("查询商品详情失败");
        }
        return AppResponse.success("查询商品详情成功", goodsInfo);
    }

    /**
     * 查询商品评价
     * @param goodsEvaluation
     * @return
     * @author zhaorujie
     * @data 2020/4/12
     */
    public AppResponse getListGoodsEvaluation(GoodsEvaluation goodsEvaluation){
        PageHelper.startPage(goodsEvaluation.getPageNum(), goodsEvaluation.getPageSize());
        List<GoodsEvaluationVO> listGoodsEvaluation = goodsDao.getListGoodsEvaluation(goodsEvaluation);
        PageInfo<GoodsEvaluationVO> pageData = new PageInfo<>(listGoodsEvaluation);
        return AppResponse.success("查询商品评价成功",pageData);
    }

    /**
     * 获取商品一级分类
     * @return
     * @author zhaorujie
     * @data 2020/4/12
     */
    public AppResponse getFirstGoodsCategory(){
        List<GoodsCategory> firstGoodsCategory = goodsDao.getFirstGoodsCategory();
        if(firstGoodsCategory.size() == 0){
            return AppResponse.bizError("获取商品一级分类失败");
        }
        //封装数据
        FirstCategoryList firstCategory = new FirstCategoryList();
        firstCategory.setOneClassifyList(firstGoodsCategory);
        return AppResponse.success("获取商品一级分类成功", firstCategory);
    }

    /**
     * 获取商品二级分类及商品
     * @param classifyId
     * @return
     * @author zhaorujie
     * @data 2020/4/12
     */
    public AppResponse getSecondGoodsCategory(String classifyId){
        List<GoodsCategory> secondGoodsCategory = goodsDao.getSecondGoodsCategory(classifyId);
        if(secondGoodsCategory.size() == 0){
            return AppResponse.bizError("获取商品二级分类及商品失败");
        }
        //封装数据
        SecondCategoryList secondCategory = new SecondCategoryList();
        secondCategory.setTowClassifyList(secondGoodsCategory);
        return AppResponse.success("获取商品二级分类及商品失败", secondCategory);
    }
}
