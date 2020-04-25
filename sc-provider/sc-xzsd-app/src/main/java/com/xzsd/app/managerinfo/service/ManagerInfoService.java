package com.xzsd.app.managerinfo.service;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.managerinfo.dao.MangerInfoDao;
import com.xzsd.app.managerinfo.entity.ManagerInfo;
import com.xzsd.app.managerinfo.entity.ManagerInfoList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 查司机信息
 * @author zhaorujie
 * @date 2020/4/14
 */
@Service
public class ManagerInfoService {
    @Resource
    private MangerInfoDao mangerInfoDao;

    /**
     * 查询给当前门店送货的所有司机信息列表
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020/4/14
     */
    public AppResponse getListDriver(String userId){
        List<ManagerInfo> listDriver = mangerInfoDao.getListDriver(userId);
        if(listDriver.size() == 0){
            return AppResponse.versionError("当前门店下没有司机");
        }
        //封装数据
        ManagerInfoList list = new ManagerInfoList();
        list.setList(listDriver);
        return AppResponse.success("查询司机信息列表成功", list);
    }
}
