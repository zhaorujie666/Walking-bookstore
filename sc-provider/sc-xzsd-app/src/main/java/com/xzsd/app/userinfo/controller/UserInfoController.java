package com.xzsd.app.userinfo.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.userinfo.entity.UserInfo;
import com.xzsd.app.userinfo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户信息查，改
 * @author zhaorujie
 * @date 2020/4/8
 */
@RestController
@RequestMapping("userInformation")
public class UserInfoController {
    public static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Resource
    private UserInfoService userInfoService;

    /**
     * 查询用户个人信息
     *
     * @return
     * @author zhaorujie
     * @date 2020/4/8
     */
    @PostMapping("getAppUser")
    public AppResponse getUserInfo(){
        try {
            String loginUserId = SecurityUtils.getCurrentUserId();
            return userInfoService.getUserInfo(loginUserId);
        }catch (Exception e){
            logger.error("获取用户个人信息失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 更新用户个人信息
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    @PostMapping("updateAppUser")
    public AppResponse updateUserInfo(UserInfo userInfo){
        try {
            String loginUserId = SecurityUtils.getCurrentUserId();
            userInfo.setUserId(loginUserId);
            return userInfoService.updateUserInfo(userInfo);
        }catch (Exception e){
            logger.error("更新用户个人信息失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户密码
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword(UserInfo userInfo){
        try {
            String loginUserId = SecurityUtils.getCurrentUserId();
            userInfo.setUserId(loginUserId);
            return userInfoService.updateUserPassword(userInfo);
        }catch (Exception e){
            logger.error("修改密码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
