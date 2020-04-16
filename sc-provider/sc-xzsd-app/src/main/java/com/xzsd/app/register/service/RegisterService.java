package com.xzsd.app.register.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.Register;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description 用户新增业务逻辑
 * @author zhaorujie
 * @date 2020/4/8
 */
@Service
public class RegisterService {
    @Resource
    private RegisterDao registerDao;

    /**
     * 注册用户
     *
     * @param register
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse registerUser(Register register){
        int count = registerDao.countUserAcctAndPhone(register);
        if(0 != count){
            return AppResponse.bizError("存在相同的账号或手机号，请重新输入！");
        }
        register.setUserId(StringUtil.getCommonCode(2));
        register.setCustomerId(StringUtil.getCommonCode(2));
        //把用户密码加密
        String userPassword = register.getUserPassword();
        String pwd = PasswordUtils.generatePassword(userPassword);
        register.setUserPassword(pwd);
        int registerCount = registerDao.registerUser(register);
        int num = registerDao.addInviteCode(register);
        if(0 == registerCount || 0 == num){
            return AppResponse.bizError("注册用户失败，请重新注册！");
        }
        return AppResponse.success("注册用户成功！");
    }
}
