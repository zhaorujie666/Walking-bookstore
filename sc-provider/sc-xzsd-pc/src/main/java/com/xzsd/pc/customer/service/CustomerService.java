package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @DescriptionDemo 实现类
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private UserDao userDao;

    /**
     * 查询顾客列表（分页）
     * @param customerInfo
     * @return
     */
    public AppResponse getListCustomers(CustomerInfo customerInfo, String userId){
        //获取当前的登录用户
        String userRole = userDao.getUserRole(userId);
        List<CustomerVO> listCustomers;
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        //判断是不是管理员,管理员查全部，店长查自己的客户
        if("0".equals(userRole) == false){
            listCustomers = customerDao.getListCustomers(customerInfo);
        }else{
            listCustomers = customerDao.getListCustomersByAdmin(customerInfo);
        }
        PageInfo<CustomerVO> pageData = new PageInfo<>(listCustomers);
        return AppResponse.success("查询成功！", pageData);
    }
}
