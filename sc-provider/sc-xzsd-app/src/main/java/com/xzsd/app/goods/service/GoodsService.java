package com.xzsd.app.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
            return AppResponse.versionError("查询商品详情失败");
        }
        //每进入一次商品详情页面浏览量就加一
        int count = goodsDao.updateGoodsViewNumber(goodsId);
        if(0 == count){
            return AppResponse.versionError("更新商品的浏览量");
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
        //分页
        PageHelper.startPage(goodsEvaluation.getPageNum(), goodsEvaluation.getPageSize());
        //查询当前商品的所有评价
        List<GoodsEvaluationVO> listGoodsEvaluation = goodsDao.getListGoodsEvaluation(goodsEvaluation);
        PageInfo<GoodsEvaluationVO> pageData = new PageInfo<>(listGoodsEvaluation);
        if(pageData.getList().size() == 0){
            return AppResponse.success("该商品未有评价", pageData);
        }
        //查询当前商品的所有评价下的每个用户的评价图片
        List<EvaluationImage> listGoodsImage = goodsDao.getListGoodsImage(goodsEvaluation);
        for (int i = 0; i < listGoodsEvaluation.size(); i++) {
            if(listGoodsEvaluation.get(i).getAppraiseId() != null){
                List<EvaluationImage> imageList = new ArrayList<>();
                for(int j = 0; j < listGoodsImage.size(); j++){
                    //判断用户的id是否相等
                    if(listGoodsEvaluation.get(i).getUserId().equals(listGoodsImage.get(j).getUserId())){
                        imageList.add(listGoodsImage.get(j));
                    }
                }
                listGoodsEvaluation.get(i).setImageList(imageList);
            }
        }
        return AppResponse.success("查询商品评价成功", pageData);
    }

    /**
     * 获取商品一级分类
     * @return
     * @author zhaorujie
     * @data 2020/4/12
     */
    public AppResponse getFirstGoodsCategory(){
        List<GoodsCategory> firstGoodsCategory = goodsDao.getFirstGoodsCategory();
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
        //获取所有二级分类
        List<GoodsCategory> secondGoodsCategory = goodsDao.getSecondGoodsCategory(classifyId);
        //获取所有商品
        List<GoodsInfo> goodsList = goodsDao.getGoodsList(classifyId);
        for (int i = 0; i < secondGoodsCategory.size(); i++) {
            List<GoodsInfo> goodsInfoList = new ArrayList<>();
            for(int j = 0; j < goodsList.size(); j++){
                if(secondGoodsCategory.get(i).getClassifyId().equals(goodsList.get(j).getGoodsSecondCategory())){
                    goodsInfoList.add(goodsList.get(j));
                }
            }
            secondGoodsCategory.get(i).setGoodsList(goodsInfoList);
        }
        //封装数据
        SecondCategoryList secondCategory = new SecondCategoryList();
        secondCategory.setTwoClassifyList(secondGoodsCategory);
        return AppResponse.success("获取商品二级分类及商品成功", secondCategory);
    }
}
