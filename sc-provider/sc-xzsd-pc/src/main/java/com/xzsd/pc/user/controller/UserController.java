package com.xzsd.pc.user.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 增删改查UserInfo
 * @author zhaorujie
 * @date 2020-03-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 新增用户
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-27
     */
    @PostMapping("addUser")
    public AppResponse addUser(UserInfo userInfo){
        try {
            //获取登录用户id
            String loginUserId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateUser(loginUserId);
            return userService.addUser(userInfo);
        }catch (Exception e){
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户详情
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020-3-27
     */
    @PostMapping("getUser")
    public AppResponse getUserInfoById(String userId){
        try {
            return userService.getUserInfoById(userId);
        }catch (Exception e){
            logger.error("查询用户详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-27
     */
    @PostMapping("updateUser")
    public AppResponse updateUserInfo(UserInfo userInfo){
        try {
            //获取登录用户id
            String loginUserId = SecurityUtils.getCurrentUserId();
            userInfo.setUpdateUser(loginUserId);
            return userService.updateUserInfo(userInfo);
        }catch (Exception e){
            logger.error("修改用户信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户列表
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-27
     */
    @PostMapping("listUsers")
    public AppResponse getListUser(UserInfo userInfo){
        try {
            return userService.getListUser(userInfo);
        }catch (Exception e){
            logger.error("查询用户列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除用户
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-27
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(UserInfo userInfo){
        try {
            //获取登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setUpdateUser(userId);
            return userService.deleteUser(userInfo);
        }catch (Exception e){
            logger.error("删除用户失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
