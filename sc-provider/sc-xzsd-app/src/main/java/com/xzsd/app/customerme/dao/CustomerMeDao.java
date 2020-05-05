package com.xzsd.app.customerme.dao;

import com.xzsd.app.customerme.entity.CustomerMe;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 邀请码修改
 * @author zhaorujie
 * @date 2020/4/14
 */
@Mapper
public interface CustomerMeDao {
    /**
     * 查询门店邀请码是否存在
     * @param customerMe
     * @return
     */
    int countStoreInviteCode(CustomerMe customerMe);

    /**
     * 修改邀请码
     * @param customerInfo
     * @return
     */
    int updateInviteCode(CustomerMe customerInfo);
}
