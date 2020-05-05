package com.xzsd.app.customerme.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customerme.dao.CustomerMeDao;
import com.xzsd.app.customerme.entity.CustomerMe;
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
        //判断输入的邀请码是否存在
        int inviteCode = customerMeDao.countStoreInviteCode(customerMe);
        if(0 == inviteCode){
            return AppResponse.versionError("你输入的门店邀请码不存在，请输入正确的邀请码");
        }
        int count = customerMeDao.updateInviteCode(customerMe);
        if(0 == count){
            return AppResponse.versionError("修改邀请码失败");
        }
        return AppResponse.success("修改邀请码成功");
    }
}
