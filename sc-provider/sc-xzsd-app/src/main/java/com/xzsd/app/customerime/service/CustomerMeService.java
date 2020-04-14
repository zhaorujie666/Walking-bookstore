package com.xzsd.app.customerime.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customerime.dao.CustomerMeDao;
import com.xzsd.app.customerime.entity.CustomerMe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description 修改邀请码业务逻辑
 * @author zhaorujie
 * @date 2020/4/14
 */
@Service
public class CustomerMeService {
    @Resource
    private CustomerMeDao customerMeDao;

    /**
     * 修改邀请码
     * @param customerMe
     * @return
     * @author zhaorujie
     * @date 2020/4/14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateInviteCode(CustomerMe customerMe){
        int count = customerMeDao.updateInviteCode(customerMe);
        if(0 == count){
            return AppResponse.bizError("修改邀请码失败");
        }
        return AppResponse.success("修改邀请码成功");
    }
}
