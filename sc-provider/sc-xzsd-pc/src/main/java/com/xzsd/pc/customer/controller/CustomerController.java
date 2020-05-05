package com.xzsd.pc.customer.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查CustomerInfo
 * @author zhaorujie
 * @date 2020-03-25
 */
@RestController
@RequestMapping("/client")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;

    /**
     * 查询客户列表（分页）
     * @param customerInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-26
     */
    @PostMapping("listClients")
    public AppResponse getListCustomers(CustomerInfo customerInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            customerInfo.setUserId(userId);
            return customerService.getListCustomers(customerInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
