package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @DescriptionDemo 客户的实现类
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    /**
     * 查询顾客列表（分页）
     * @param customerInfo
     * @return
     */
    public AppResponse getListCustomers(CustomerInfo customerInfo){
        List<CustomerVO> listCustomers = null;
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        //判断是不是管理员,管理员查全部，店长查自己的客户
        if("2".equals(customerInfo.getRole())){
            listCustomers = customerDao.getListCustomers(customerInfo);
        }else if("0".equals(customerInfo.getRole()) || "1".equals(customerInfo.getRole())){
            listCustomers = customerDao.getListCustomersByAdmin(customerInfo);
        }
        PageInfo<CustomerVO> pageData = new PageInfo<>(listCustomers);
        return AppResponse.success("查询成功！", pageData);
    }
}
