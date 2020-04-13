package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.category.entity.GoodsCategoryVO;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.*;
import com.xzsd.pc.util.RandomUtil;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author zhaorujie
 * @Date 2020-03-28
 */
@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;


    /**
     * 新增商品
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goodsInfo){
        //判断是否出现重复的书号
        int count = goodsDao.countBookNumber(goodsInfo.getIsbn());
        if(count != 0){
            return AppResponse.success("书号重复，请输入正确的书号！");
        }
        //判断传入的字段是否为空
        if(null == goodsInfo.getGoodsAdvertise()){
            goodsInfo.setGoodsAdvertise("");
        }
        if(null == goodsInfo.getGoodsDescribe()){
            goodsInfo.setGoodsDescribe("");
        }
        //生成商品id
        goodsInfo.setGoodsId(StringUtil.getCommonCode(2));
        //生成商家编码
        goodsInfo.setStoreId(RandomUtil.randomLetter(3) + StringUtil.getCommonCode(2));
        int goods = goodsDao.addGoods(goodsInfo);
        if(goods == 0){
            return AppResponse.success("新增商品失败");
        }
        return AppResponse.success("新增商品成功");
    }

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author zhaorujie
     * @Date 2020-03-28
     */
    public AppResponse getGoodsInfoById(String goodsId){
        GoodsVTO goodsInfo = goodsDao.getGoodsInfoById(goodsId);
        if(goodsInfo == null){
            return AppResponse.success("查询商品详情失败！");
        }
        //设置商品一二级分类名称
        /*List<String> categoryName = goodsDao.getGoodsCategoryName(goodsId);
        globalGoodsInfo.setOneClassifyName(categoryName.get(0));
        globalGoodsInfo.setTwoClassifyName(categoryName.get(1));*/
        return AppResponse.success("查询商品详情成功！", goodsInfo);
    }

    /**
     * 获取商品一二级分类
     * @param classifyId
     * @return
     * @author zhaorujie
     * @Date 2020-03-28
     */
    public AppResponse getListGoodsCategory(String classifyId){
        List<GoodsCategoryVO> listGoodsCategory = goodsDao.getListGoodsCategory(classifyId);
        if(listGoodsCategory.size() == 0){
            return AppResponse.bizError("获取商品分类失败！");
        }
        //封装成接口文档需要的名称
        GoodsCategoryList goodsClassifyList = new GoodsCategoryList();
        goodsClassifyList.setGoodsClassifyList(listGoodsCategory);
        return AppResponse.success("获取商品分类成功！", goodsClassifyList);
    }

    /**
     * 修改商品信息
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsInfo(GoodsInfo goodsInfo){
        GoodsVTO goods = goodsDao.getGoodsInfoById(goodsInfo.getGoodsId());
        //判断当前的书号有没有改变
        int count = goodsDao.countBookNumber(goodsInfo.getIsbn());
        if(count != 0 && goods.getIsbn().equals(goodsInfo.getIsbn()) == false){
            return AppResponse.success("存在相同的书号，请输入正确的书号！");
        }
        //判断传入的字段是否为空
        if(null == goodsInfo.getGoodsAdvertise()){
            goodsInfo.setGoodsAdvertise("");
        }
        if(null == goodsInfo.getGoodsDescribe()){
            goodsInfo.setGoodsDescribe("");
        }
        int number = goodsDao.updateGoodsInfo(goodsInfo);
        if(number == 0){
            return AppResponse.success("修改商品信息失败！");
        }
        return AppResponse.success("修改商品信息成功！");
    }

    /**
     * 更新商品状态
     * @param goodsId
     * @param goodsStateId
     * @param userId
     * @return
     * @author zhaorujie
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsStatus(String goodsId,
                                         String goodsStateId,
                                         String userId){
        List<String> listGoodsId = Arrays.asList(goodsId.split(","));
        int count = goodsDao.updateGoodsStatus(listGoodsId, goodsStateId, userId);
        if(count == 0){
            return AppResponse.success("更新商品状态失败！");
        }
        return AppResponse.success("更新商品状态成功！");
    }

    /**
     * 查询商品列表（分页）
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @Date 2020-03-28
     */
    public AppResponse getListGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsVO> listGoods = goodsDao.getListGoods(goodsInfo);
        PageInfo<GoodsVO> pageData = new PageInfo<>(listGoods);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除商品
     * @param goodsId
     * @param userId
     * @return
     * @author zhaorujie
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId, String userId){
        List<String> list = Arrays.asList(goodsId.split(","));
        int count = goodsDao.deleteGoods(list, userId);
        if(count == 0){
            return AppResponse.success("删除失败！");
        }
        return AppResponse.success("删除成功！");
    }
}
