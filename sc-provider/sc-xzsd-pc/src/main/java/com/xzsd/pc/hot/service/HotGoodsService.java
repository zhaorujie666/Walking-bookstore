package com.xzsd.pc.hot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.hot.dao.HotGoodsDao;
import com.xzsd.pc.hot.entity.HotGoodsInfo;
import com.xzsd.pc.hot.entity.HotGoodsVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 实现类
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
        int num = hotGoodsDao.countSort(hotGoodsInfo);
        if(num != 0){
            return AppResponse.bizError("出现重复的排序，请重新输入！");
        }
        hotGoodsInfo.setHotId(StringUtil.getCommonCode(2));
        hotGoodsDao.addHotGoods(hotGoodsInfo);
        return AppResponse.success("新增热门商品成功！");
    }

    /**
     * 查询热门商品详情
     * @param hotId
     * @return
     */
    HotGoodsVO globalHotGoods = null;
    public AppResponse getHotGoodsById(String hotId){
        globalHotGoods = hotGoodsDao.getHotGoodsById(hotId);
        if(globalHotGoods == null){
            return AppResponse.bizError("查询热门商品详情失败");
        }
        return AppResponse.success("查询热门商品详情成功！", globalHotGoods);
    }

    /**
     * 修改热门商品
     * @param hotGoodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        int num = hotGoodsDao.countSort(hotGoodsInfo);
        if(num != 0 && globalHotGoods.getSort() != hotGoodsInfo.getSort()){
            return AppResponse.bizError("存在相同的排序，请重新输入");
        }
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if(count == 0){
            return AppResponse.bizError("修改热门商品失败！");
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
     * 修改热门商品展示数量
     * @param showNumber
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse modifyShowNumber(String showNumber, String userId){
        int count = hotGoodsDao.modifyShowNumber(showNumber, userId);
        if(count == 0){
            return AppResponse.bizError("修改热门商品展示数量失败");
        }
        return AppResponse.success("修改热门商品展示数量成功");
    }

    /**
     * 删除热门位商品
     * @param hotId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotId, String userId){
        List<String> listHotId = Arrays.asList(hotId.split(","));
        int count = hotGoodsDao.deleteHotGoods(listHotId, userId);
        if(count == 0){
            return AppResponse.bizError("删除失败！");
        }
        return AppResponse.success("删除成功！");

    }
}
