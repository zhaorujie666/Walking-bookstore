package com.xzsd.pc.hotgoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsShowNumber;
import com.xzsd.pc.hotgoods.entity.HotGoodsVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 热门商品实现类，增删改查
 * @author zhaorujie
 * @date 2020-3-31
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;
    @Resource
    private UserDao userDao;

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        //校验排序是否重复
        int num = hotGoodsDao.countSort(hotGoodsInfo);
        if(num != 0){
            return AppResponse.versionError("出现重复的排序，请重新输入！");
        }
        //校验商品是否已经被选择
        int goodsIsUse = hotGoodsDao.countGoodsIsUse(hotGoodsInfo);
        if(goodsIsUse != 0){
            return AppResponse.versionError("该商品已经被选择，请重新选择");
        }
        hotGoodsInfo.setHotGoodsId(StringUtil.getCommonCode(2));
        hotGoodsDao.addHotGoods(hotGoodsInfo);
        return AppResponse.success("新增热门商品成功！");
    }

    /**
     * 查询热门商品详情
     * @param hotGoodsId
     * @return
     */
    public AppResponse getHotGoodsById(String hotGoodsId){
        HotGoodsVO hotGoods = hotGoodsDao.getHotGoodsById(hotGoodsId);
        if(hotGoods == null){
            return AppResponse.versionError("查询热门商品详情失败");
        }
        return AppResponse.success("查询热门商品详情成功！", hotGoods);
    }

    /**
     * 修改热门商品
     * @param hotGoodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        HotGoodsVO hotGoods = hotGoodsDao.getHotGoodsById(hotGoodsInfo.getHotGoodsId());
        if(hotGoods.getHotGoodsNum() != hotGoodsInfo.getHotGoodsNum()){
            //校验排序是否重复
            int num = hotGoodsDao.countSort(hotGoodsInfo);
            if(0 != num){
                return AppResponse.versionError("出现相同的排序，请重新输入");
            }
        }
        //校验商品是否已经被选择
        int goodsIsUse = hotGoodsDao.countGoodsIsUse(hotGoodsInfo);
        if(!hotGoods.getGoodsId().equals(hotGoodsInfo.getGoodsId())){
            if(0 != goodsIsUse){
                return AppResponse.versionError("该商品已经被选择，请重新选择");
            }
        }
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if(count == 0){
            return AppResponse.versionError("修改热门商品失败！");
        }
        return AppResponse.success("修改门商品成功！");
    }

    /**
     * 查询热门商品列表（分页）
     * @param hotGoodsInfo
     * @return
     */
    public AppResponse getListHotGoods(HotGoodsInfo hotGoodsInfo){
        PageHelper.startPage(hotGoodsInfo.getPageNum(), hotGoodsInfo.getPageSize());
        List<HotGoodsVO> listHotGoods = hotGoodsDao.getListHotGoods(hotGoodsInfo);
        PageInfo<HotGoodsVO> pageData = new PageInfo<>(listHotGoods);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 查询热门商品展示数量
     * @return
     */
    public AppResponse getHotGoodsShowNumber(){
        HotGoodsShowNumber hotGoodsShowNumber = hotGoodsDao.getHotGoodsShowNumber();
        return AppResponse.success("查询热门商品展示数量成功", hotGoodsShowNumber);
    }

    /**
     * 修改热门商品展示数量
     * @param hotGoodsShowNumber
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse modifyShowNumber(HotGoodsShowNumber hotGoodsShowNumber){
        int count = hotGoodsDao.modifyShowNumber(hotGoodsShowNumber);
        if(count == 0){
            return AppResponse.versionError("修改热门商品展示数量失败");
        }
        return AppResponse.success("修改热门商品展示数量成功");
    }

    /**
     * 删除热门位商品
     * @param hotGoodsId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotGoodsId, String userId){
        List<String> listHotId = Arrays.asList(hotGoodsId.split(","));
        int count = hotGoodsDao.deleteHotGoods(listHotId, userId);
        if(count == 0){
            return AppResponse.versionError("删除失败！");
        }
        return AppResponse.success("删除成功！");

    }
}
