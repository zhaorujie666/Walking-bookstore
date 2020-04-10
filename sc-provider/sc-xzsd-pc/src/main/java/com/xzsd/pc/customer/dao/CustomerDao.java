package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CustomerDao
 * @Description CustomerInfo
 * @Author zhaorujie
 * @Date 2020-03-26
 */
@Mapper
public interface CustomerDao {
    /**
     * 获取店长邀请码
     * @param loginId
     * @return
     */
    String getInvitationCode(@Param("loginId") String loginId);

    /**
     * 查询当前登录用户是店长时的所有客户信息
     * @param customerInfo
     * @return
     */
    List<CustomerVO> getListCustomers(CustomerInfo customerInfo);

    /**
     * 查询登录者为管理员时的用户列表
     * @param customerInfo
     * @return
     */
    List<CustomerVO> getListCustomersByAdmin(CustomerInfo customerInfo);
}
