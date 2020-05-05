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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 商品增删改查
 * @author zhaorujie
 * @date 2020-03-28
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
     * @date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goodsInfo){
        //判断是否出现重复的书号
        int count = goodsDao.countBookNumber(goodsInfo);
        if(count != 0){
            return AppResponse.versionError("书号重复，请输入正确的书号！");
        }
        //生成商品id
        goodsInfo.setGoodsId(StringUtil.getCommonCode(2));
        //生成商家编码
        goodsInfo.setStoreId(RandomUtil.randomLetter(3) + StringUtil.getCommonCode(2));
        int goods = goodsDao.addGoods(goodsInfo);
        if(goods == 0){
            return AppResponse.versionError("新增商品失败");
        }
        return AppResponse.success("新增商品成功");
    }

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    public AppResponse getGoodsInfoById(String goodsId){
        GoodsDetails goodsInfo = goodsDao.getGoodsInfoById(goodsId);
        if(goodsInfo == null){
            return AppResponse.versionError("查询商品详情失败！");
        }
        return AppResponse.success("查询商品详情成功！", goodsInfo);
    }

    /**
     * 获取商品一二级分类
     * @param classifyId
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    public AppResponse getListGoodsCategory(String classifyId){
        List<GoodsCategoryVO> listGoodsCategory = goodsDao.getListGoodsCategory(classifyId);
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
     * @date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsInfo(GoodsInfo goodsInfo){
        //判断是否出现重复的书号
        int count = goodsDao.countBookNumber(goodsInfo);
        if(0 != count){
            return AppResponse.versionError("存在相同的书号，请输入正确的书号！");
        }
        int number = goodsDao.updateGoodsInfo(goodsInfo);
        if(number == 0){
            return AppResponse.versionError("修改商品信息失败！");
        }
        return AppResponse.success("修改商品信息成功！");
    }

    /**
     * 更新商品状态
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsStatus(GoodsInfo goodsInfo){
        //分割字符
        List<String> listGoodsId = Arrays.asList(goodsInfo.getGoodsId().split(","));
        List<String> listVersion = Arrays.asList(goodsInfo.getVersion().split(","));
        List<String> goodsInventories = Arrays.asList(goodsInfo.getGoodsInventories().split(","));
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        for (int i = 0; i < listGoodsId.size() && i <listVersion.size() && i < goodsInventories.size(); i++) {
            //当库存为0时即状态为售罄，就不能把商品状态改为在售
            if(Integer.valueOf(goodsInventories.get(i)) == 0 && "1".equals(goodsInfo.getGoodsStateId())){
                continue;
            }
            GoodsInfo info = new GoodsInfo();
            //设置商品id
            info.setGoodsId(listGoodsId.get(i));
            //设置版本号
            info.setVersion(listVersion.get(i));
            //设置更新人
            info.setUpdateUser(goodsInfo.getUpdateUser());
            //设置商品状态
            info.setGoodsStateId(goodsInfo.getGoodsStateId());
            goodsInfoList.add(info);
        }
        if(goodsInfoList.size() == 0){
            return AppResponse.versionError("当前商品已售罄库存为0，不能再把商品上架！");
        }
        int count = goodsDao.updateGoodsStatus(goodsInfoList);
        if(count == 0){
            return AppResponse.versionError("更新商品状态失败！");
        }
        return AppResponse.success("更新商品状态成功！");
    }

    /**
     * 查询商品列表（分页）
     * @param goodsInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    public AppResponse getListGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsVO> listGoods = goodsDao.getListGoods(goodsInfo);
        PageInfo<GoodsVO> pageData = new PageInfo<>(listGoods);
        return AppResponse.success("查询商品列表成功！", pageData);
    }

    /**
     * 删除商品
     * @param goodsId 商品id
     * @param userId 登录用户id
     * @return
     * @author zhaorujie
     * @date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId, String userId){
        List<String> list = Arrays.asList(goodsId.split(","));
        List<String> goodsIdList = goodsDao.querySlideAndHotGoods(list);
        //去除已经被轮播图和热门商品使用的商品id
        List<String> listGoodsId = new ArrayList<>();
        int flag = 0;
        int j;
        for (int i = 0; i < list.size(); i++) {
            for(j = 0; j < goodsIdList.size(); j++){
               if(!list.get(i).equals(goodsIdList.get(j))){
                   flag++;
               }
            }
            //判断次数是否相同，相同就说明该商品不被用于轮播图或热门商品
            if(flag == j){
                listGoodsId.add(list.get(i));
            }
            flag = 0;
        }
        if(listGoodsId.size() == 0){
            return AppResponse.versionError("该商品已经被用于轮播图或热门商品，所有不能删除");
        }
        int count = goodsDao.deleteGoods(listGoodsId, userId);
        if(count == 0){
            return AppResponse.versionError("删除失败！");
        }
        return AppResponse.success("删除成功！");
    }
}
