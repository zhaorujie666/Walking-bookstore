package com.xzsd.app.driverinfo.dao;

import com.xzsd.app.driverinfo.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 查店长信息列表
 * @author zhaorujie
 * @date 2020/4/12
 */
@Mapper
public interface DriverInfoDao {
    /**
     * 查店长信息列表
     * @param driverInfo
     * @return
     */
    List<DriverInfo> getListStoreInfo(DriverInfo driverInfo);
}
