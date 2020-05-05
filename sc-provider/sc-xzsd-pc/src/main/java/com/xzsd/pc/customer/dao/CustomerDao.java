package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName CustomerDao
 * @Description CustomerInfo
 * @author zhaorujie
 * @date 2020-03-26
 */
@Mapper
public interface CustomerDao {
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
