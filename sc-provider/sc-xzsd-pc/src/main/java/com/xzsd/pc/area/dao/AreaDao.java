package com.xzsd.pc.area.dao;


import com.xzsd.pc.area.entity.AreaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName AreaDao
 * @Description Area
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Mapper
public interface AreaDao {

    /**
     * 查询省市区
     * @param parentId
     * @return
     */
    List<AreaVO> getListArea(@Param("parentId") String parentId);
}
