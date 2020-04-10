package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName StoreDao
 * @Description Store
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Mapper
public interface StoreDao {
    /**
     * 统计营业执照编码数量
     * @param storeInfo 门店信息
     * @return
     */
    int countBusinessCode(StoreInfo storeInfo);
    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 查询店长编号
     * @param storeInfo
     * @return
     */
    StoreInfo getManagerId(StoreInfo storeInfo);

    /**
     * 查询门店详情信息
     * @param storeCode
     * @return
     */
    StoreVO getStoreInfoById(@Param("storeCode") String storeCode);

    /**
     * 修改店详情信息
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 查询所有门店信息
     * @param storeInfo
     * @return
     */
    List<StoreVO> getListStore(StoreInfo storeInfo);

    /**
     * 删除门店信息
     * @param listStoreCode
     * @return
     */
    int deleteStoreById(List<String> listStoreCode, @Param("userId") String userId);
}
