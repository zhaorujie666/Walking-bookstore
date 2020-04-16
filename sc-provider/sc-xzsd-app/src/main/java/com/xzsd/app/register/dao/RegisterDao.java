package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.Register;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户注册dao层
 * @author zhaorujie
 * @date 2020/4/8
 */
@Mapper
public interface RegisterDao {
    /**
     * 注册用户
     * @param register
     * @return
     */
    int registerUser(Register register);

    /**
     * 新增邀请码
     * @param register
     * @return
     */
    int addInviteCode(Register register);

    /**
     * 统计用户账号
     * @param register
     * @return
     */
    int countUserAcctAndPhone(Register register);
}
