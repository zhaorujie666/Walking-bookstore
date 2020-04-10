package com.xzsd.app.userinfo.dao;

import com.xzsd.app.userinfo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description dao层
 * @author zhaorujie
 * @date 2020/4/8
 */
@Mapper
public interface UserInfoDao {
    /**
     * 查询登录用户角色
     * @param loginUserId
     * @return
     */
    String getLoginUserRole(@Param("loginUserId") String loginUserId);

    /**
     * 查询店长个人信息
     *
     * @param loginUserId
     * @return
     */
    UserInfo getStoreInfo(@Param("loginUserId") String loginUserId);

    /**
     * 查询司机个人信息
     *
     * @param loginUserId
     * @return
     */
    UserInfo getDriverInfo(@Param("loginUserId") String loginUserId);

    /**
     * 查询客户个人信息
     *
     * @param loginUserId
     * @return
     */
    UserInfo getCustomerInfo(@Param("loginUserId") String loginUserId);

    /**
     * 修改用户个人信息（修改名称或头像）
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 修改用户密码
     *
     * @param userInfo
     * @return
     */
    int updateUserPassword(UserInfo userInfo);

    /**
     * 获取登录用户的密码
     *
     * @param userId
     * @return
     */
    String getUserPasswordById(@Param("userId") String userId);
}
