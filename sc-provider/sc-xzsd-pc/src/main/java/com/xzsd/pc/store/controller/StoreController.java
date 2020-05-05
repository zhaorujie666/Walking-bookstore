package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 门店管理增删改查StoreInfo
 * @author zhaorujie
 * @date 2020-03-25
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Resource
    private StoreService storeService;

    /**
     * 新增门店信息
     * @param storeInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateUser(userId);
            storeInfo.setLoginUserId(userId);
            return storeService.addStore(storeInfo);
        }catch (Exception e){
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店详情
     * @param storeId
     * @return
     * @author zhaorujie
     * @date 2020-03-26
     */
    @PostMapping("getStore")
    public AppResponse getStoreInfoById(String storeId){
        try {
            return storeService.getStoreInfoById(storeId);
        }catch (Exception e){
            logger.error("查询门店详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-26
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo){
        try {
            //获取用户的id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUpdateUser(userId);
            storeInfo.setLoginUserId(userId);
            return storeService.updateStore(storeInfo);
        }catch (Exception e){
            logger.error("修改门店信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店信息列表（分页）
     * @param storeInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-26
     */
    @PostMapping("listStores")
    public AppResponse getListStore(StoreInfo storeInfo){
        try {
            //获取当前登录者的id
            String loginUserId = SecurityUtils.getCurrentUserId();
            storeInfo.setUserId(loginUserId);
            return storeService.getListStore(storeInfo);
        }catch (Exception e){
            logger.error("查询门店信息列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店
     * @param storeId 门店id
     * @param nowRole 登录的用户角色·
     * @return
     * @author zhaorujie
     * @date 2020-03-26
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStoreById(String storeId, String nowRole){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStoreById(storeId, userId, nowRole);
        }catch (Exception e){
            logger.error("删除门店成功", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
