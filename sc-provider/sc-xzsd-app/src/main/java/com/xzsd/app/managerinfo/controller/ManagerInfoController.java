package com.xzsd.app.managerinfo.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.managerinfo.service.ManagerInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查询给门店送货的所有司机
 * @author zhaorujie
 * @date 2020/4/14
 */
@RestController
@RequestMapping("manangerInformation")
public class ManagerInfoController {
    public static final Logger logger = LoggerFactory.getLogger(ManagerInfoController.class);

    @Resource
    private ManagerInfoService managerInfoService;

    /**
     * 查询司机信息列表
     * @return
     */
    @PostMapping("listManangerDrivers")
    public AppResponse getListDriver(){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return managerInfoService.getListDriver(userId);
        }catch (Exception e){
            logger.error("查询司机信息列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
