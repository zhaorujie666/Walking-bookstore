package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName StoreDao 门店Dao层
 * @Description Store
 * @author zhaorujie
 * @date 2020-03-25
 */
@Mapper
public interface StoreDao {
    /**
     * 统计营业执照编码数量和店长编
     * @param storeInfo 门店信息
     * @return
     */
    int countBusinessCode(StoreInfo storeInfo);

    /**
     * 校验是否出现重复的邀请码
     * @param storeInfo
     * @return
     */
    int countInviteCode(StoreInfo storeInfo);
    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 查询门店详情信息
     * @param storeId
     * @return
     */
    StoreVO getStoreInfoById(@Param("storeId") String storeId);

    /**
     * 修改店详情信息
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 店长查询自己门店信息
     * @param storeInfo
     * @return
     */
    List<StoreVO> getListStore(StoreInfo storeInfo);

    /**
     * 管理员查询所有门店信息
     * @param storeInfo
     * @return
     */
    List<StoreVO> getListStoreByAdmin(StoreInfo storeInfo);

    /**
     * 删除门店信息
     * @param listStoreId
     * @param loginUserId
     * @return
     */
    int deleteStoreById(@Param("listStoreId") List<String> listStoreId, @Param("loginUserId") String loginUserId);

    /**
     * 查询当前要删除的门店是否有订单
     * @param listStoreId
     * @return
     */
    List<String> queryStoreBindOrder(@Param("listStoreId") List<String> listStoreId);
}
