package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 获取登录者角色
     * @param loginUserId
     * @return
     */
    String getUserRole(@Param("loginUserId") String loginUserId);

    /**
     * 统计用户账号
     * @param userInfo
     * @return
     */
    int countUserAccount(UserInfo userInfo);

    /**
     * 统计手机号
     * @param userInfo
     * @return
     */
    int countPhone(UserInfo userInfo);

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 查询用户详情
     * @param userId
     * @return
     */
    UserVO getUserInfoById(@Param("userId") String userId);

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 查询用户列表（分页）
     * @param userInfo
     * @return
     */
    List<UserVO> getListUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param listUserId
     * @param loginUserId
     * @return
     */
    int deleteUser(@Param("listUserId") List<String> listUserId, @Param("loginUserId") String loginUserId);
}
