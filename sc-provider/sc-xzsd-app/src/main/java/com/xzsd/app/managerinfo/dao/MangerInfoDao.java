package com.xzsd.app.managerinfo.dao;

import com.xzsd.app.managerinfo.entity.ManagerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 查
 * @author zhaorujie
 * @date 2020/4/14
 */
@Mapper
public interface MangerInfoDao {
    /**
     * 查询负责给店长送货的所有司机
     * @param userId
     * @return
     */
    List<ManagerInfo> getListDriver(@Param("userId") String userId);
}
