package com.xzsd.pc.store.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查StoreInfo
 * @Author zhaorujie
 * @Date 2020-03-25
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
     * @Date 2020-03-25
     */
    @PostMapping("/addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateUser(userId);
            return storeService.addStore(storeInfo);
        }catch (Exception e){
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     * @author zhaorujie
     * @Date 2020-03-26
     */
    @PostMapping("/findStoreById")
    public AppResponse getStoreInfoById(String storeCode){
        try {
            return storeService.getStoreInfoById(storeCode);
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
     * @Date 2020-03-26
     */
    @PostMapping("/updateStoreById")
    public AppResponse updateStore(StoreInfo storeInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUpdateUser(userId);
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
     * @Date 2020-03-26
     */
    @PostMapping("/listStore")
    public AppResponse getListStore(StoreInfo storeInfo){
        try {
            return storeService.getListStore(storeInfo);
        }catch (Exception e){
            logger.error("查询门店信息列表成功", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店
     * @param storeCode
     * @param userId
     * @return
     * @author zhaorujie
     * @Date 2020-03-26
     */
    @PostMapping("/deleteStore")
    public AppResponse deleteStoreById(String storeCode, String userId){
        try {
            return storeService.deleteStoreById(storeCode, userId);
        }catch (Exception e){
            logger.error("删除门店成功", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
