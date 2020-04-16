package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserVO;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.RandomUtil;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        //校验是否存在相同的用户账号
        int num = userDao.countUserAccount(userInfo);
        if(num != 0){
            return AppResponse.versionError("存在相同的用户账号，请重新输入！");
        }
        //校验是否存在相同的手机号
        int countPhone = userDao.countPhone(userInfo);
        if(0 != countPhone){
            return AppResponse.versionError("该手机号已经存在，请重新输入");
        }
        //设置id
        userInfo.setUserId(StringUtil.getCommonCode(2));
        //密码加密
        String password = userInfo.getUserPassword();
        String pwd = PasswordUtils.generatePassword(password);
        userInfo.setUserPassword(pwd);
        int count = userDao.addUser(userInfo);
        if(count == 0){
            return AppResponse.versionError("新增用户失败");
        }
        return AppResponse.success("新增用户成功");
    }

    /**
     * 查询用户详情
     * @param userId
     * @return
     */
    public AppResponse getUserInfoById(String userId){
        UserVO userInfo = userDao.getUserInfoById(userId);
        if(userInfo == null){
            return AppResponse.versionError("查询失败");
        }
        return AppResponse.success("查询成功", userInfo);
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserInfo(UserInfo userInfo){
        UserVO user = userDao.getUserInfoById(userInfo.getUserId());
        if(!user.getUserAcct().equals(userInfo.getUserAcct())){
            //校验是否存在相同的账号
            int num = userDao.countUserAccount(userInfo);
            if(num != 0){
                return AppResponse.versionError("存在相同的用户账号，请重新输入！");
            }
        }
        if(!user.getPhone().equals(userInfo.getPhone())){
            //校验是否存在相同的手机号
            int countPhone = userDao.countPhone(userInfo);
            if(countPhone != 0){
                return AppResponse.versionError("该手机号已经存在，请重新输入");
            }
        }
        if(!user.getUserPassword().equals(userInfo.getUserPassword())){
            String password = userInfo.getUserPassword();
            String pwd = PasswordUtils.generatePassword(password);
            userInfo.setUserPassword(pwd);
        }

        int count = userDao.updateUserInfo(userInfo);
        if(count == 0){
            return AppResponse.versionError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 查询用户列表（分页）
     * @param userInfo
     * @return
     */
    public AppResponse getListUser(UserInfo userInfo){
        //分页查询
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserVO> listUser = userDao.getListUser(userInfo);
        PageInfo<UserVO> pageData = new PageInfo<>(listUser);
        return AppResponse.success("查询用户列表成功！", pageData);
    }

    /**
     * 删除用户
     * @param userId
     * @param loginUserId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId, String loginUserId){
        List<String> listUserId = Arrays.asList(userId.split(","));
        int count = userDao.deleteUser(listUserId, loginUserId);
        if(count == 0){
            return AppResponse.versionError("删除用户失败，请刷新页面");
        }
        return AppResponse.success("删除用户成功");
    }
}
