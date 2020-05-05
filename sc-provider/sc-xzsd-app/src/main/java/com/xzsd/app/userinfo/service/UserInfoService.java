package com.xzsd.app.userinfo.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.userinfo.dao.UserInfoDao;
import com.xzsd.app.userinfo.entity.UserInfo;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description 业务逻辑层
 * @author zhaorujie
 * @date 2020/4/8
 */
@Service
public class UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 查询用户个人信息
     *
     * @param loginUserId
     * @return
     * @author zhaorujie
     * @date 2020/4/8
     */
    public AppResponse getUserInfo(String loginUserId){
        //获取用户角色
        String loginUserRole = userInfoDao.getLoginUserRole(loginUserId);
        UserInfo userInfo = null;
        if("2".equals(loginUserRole)){
            userInfo = userInfoDao.getStoreInfo(loginUserId);
            userInfo.setAddress(userInfo.getProvinceName() + userInfo.getCityName() + userInfo.getAreaName() + userInfo.getAddress());
        }else if("3".equals(loginUserRole)){
            userInfo = userInfoDao.getDriverInfo(loginUserId);
        }else if("4".equals(loginUserRole)){
            String inviteCode = userInfoDao.getUserInviteCode(loginUserId);
            userInfo = userInfoDao.getCustomerInfo(loginUserId, inviteCode);
        }
        if(userInfo == null){
            return AppResponse.versionError("查询用户个人信息失败！");
        }
        return AppResponse.success("查询用户个人信息成功", userInfo);
    }

    /**
     * 更新用户个人信息
     *
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserInfo(UserInfo userInfo){
        int count = userInfoDao.updateUserInfo(userInfo);
        if(0 == count){
            return AppResponse.versionError("更新用户个人信息失败，请刷新页面！");
        }
        return AppResponse.success("更新用户个人信息成功");
    }

    /**
     * 修改用户密码
     *
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserPassword(UserInfo userInfo){
        //获取用户存在数据库的密码
        String userPassword = userInfoDao.getUserPasswordById(userInfo.getUserId());
        //判断原密码和数据库存的密码是否相同
        boolean flag = PasswordUtils.equalPassword(userInfo.getUserPassword(), userPassword);
        if(!flag){
            return AppResponse.versionError("输入的原密码不正确，请重新输入");
        }
        //密码加密
        String userNewPassword = userInfo.getUserNewPassword();
        String pwd = PasswordUtils.generatePassword(userNewPassword);
        userInfo.setUserNewPassword(pwd);
        int count = userInfoDao.updateUserPassword(userInfo);
        if(0 == count){
            return AppResponse.versionError("修改密码失败");
        }
        return AppResponse.success("修改密码成功");
    }
}
