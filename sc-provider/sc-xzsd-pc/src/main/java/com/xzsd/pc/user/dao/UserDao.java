package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserDetails;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 用户管理Dao层
 * @author zhaorujie
 * @date 2020-3-27
 */
@Mapper
public interface UserDao {

    /**
     * 获取登录者角色
     * @param loginUserId
     * @return
     */
    String getUserRole(@Param("loginUserId") String loginUserId);

    /**
     * 统计用户账号或手机号
     * @param userInfo
     * @return
     */
    int countUserAccountAndPhone(UserInfo userInfo);

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
    List<UserVO> queryListUserByPage(UserInfo userInfo);

    /**
     * 删除用户
     * @param listUserId
     * @param loginUserId
     * @return
     */
    int deleteUser(@Param("listUserId") List<String> listUserId, @Param("loginUserId") String loginUserId);

    /**
     * 查询当前要删除的用户是否绑定门店
     * @param listUserId
     * @return
     */
    List<String> queryBindStore(@Param("listUserId") List<String> listUserId);
}
