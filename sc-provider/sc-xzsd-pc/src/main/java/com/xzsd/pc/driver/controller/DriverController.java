package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查Driver
 * @author zhaorujie
 * @date 2020-03-24
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;

    /**
     * demo 新增司机
     * @param driverInfo
     * @return AppResponse
     * @author zhaorujie
     * @date 2020-03-24
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try{
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateUser(userId);
            driverInfo.setLoginUserId(userId);
            return driverService.addDriver(driverInfo);
        } catch (Exception e){
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机详情
     * @param driverId 司机id
     * @return AppResponse
     * @author zhaorujie
     * @date 2020-03-25
     */
    @PostMapping("getDriver")
    public AppResponse getDriverById(String driverId){
        try {
            return driverService.getDriverById(driverId);
        } catch (Exception e){
            logger.error("查询司机详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return AppResponse
     * @author zhaorujie
     * @date 2020-03-25
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUpdateUser(userId);
            driverInfo.setLoginUserId(userId);
            return driverService.updateDriver(driverInfo);
        } catch (Exception e){
            logger.error("修改司机信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机列表（分页）
     * @param driverInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @PostMapping("listDrivers")
    public AppResponse getListDriver(DriverInfo driverInfo){
        try {
            //获取当前登录人的id
            String loginUserId = SecurityUtils.getCurrentUserId();
            driverInfo.setLoginUserId(loginUserId);
            return driverService.getListDriver(driverInfo);
        }catch (Exception e){
            logger.error("查询司机列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机
     * @param driverId 司机id
     * @param nowRole 登录角色
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriverById(String driverId, String nowRole){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriverById(driverId, userId, nowRole);
        }catch (Exception e){
            logger.error("删除司机失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
