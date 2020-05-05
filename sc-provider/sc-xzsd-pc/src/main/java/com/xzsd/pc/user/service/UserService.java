package com.xzsd.pc.user.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserVO;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 用户的实现类
 * @author zhaorujie
 * @date 2020-03-25
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        //排除司机和客户登录后台可以新增用户
        if("3".equals(userInfo.getNowRole()) || "4".equals(userInfo.getNowRole())){
            return AppResponse.versionError("你没有权限");
        }
        if(userInfo.getRole().equals(userInfo.getNowRole())){
            return AppResponse.versionError("管理员不能新增管理员，只用超级管理员才能新增管理员");
        }
        //查询账号和手机是否存在
        int num = userDao.countUserAccountAndPhone(userInfo);
        if(num == 1){
            return AppResponse.versionError("存在相同的用户账号，请重新输入！");
        }
        if(num == 2){
            return AppResponse.versionError("该手机号已经存在，请重新输入");
        }
        if(num == 3){
            return AppResponse.versionError("存在相同的用户账号和手机号，请重新输入");
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
     * @author zhaorujie
     * @date 2020-03-25
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
     * @author zhaorujie
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserInfo(UserInfo userInfo){
        //排除司机和客户登录后台可以修改用户信息
        if("3".equals(userInfo.getNowRole()) || "4".equals(userInfo.getNowRole())){
            return AppResponse.versionError("你没有权限");
        }
        if(userInfo.getRole().equals(userInfo.getNowRole())){
            return AppResponse.versionError("管理员不能修改管理员的信息，并且不能把店长改为管理员，只有超级管理员才能");
        }
        UserVO user = userDao.getUserInfoById(userInfo.getUserId());
        if(!user.getUserAcct().equals(userInfo.getUserAcct()) || !String.valueOf(user.getPhone()).equals(userInfo.getPhone())){
            //查询账号和手机是否存在
            int num = userDao.countUserAccountAndPhone(userInfo);
            if(num == 1){
                return AppResponse.versionError("存在相同的用户账号，请重新输入！");
            }
            if(num == 2){
                return AppResponse.versionError("该手机号已经存在，请重新输入");
            }
            if(num == 3){
                return AppResponse.versionError("存在相同的用户账号和手机号，请重新输入");
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
     * @author zhaorujie
     * @date 2020-03-25
     */
    public AppResponse getListUser(UserInfo userInfo){
        if("3".equals(userInfo.getNowRole()) || "4".equals(userInfo.getNowRole())){
            return AppResponse.versionError("你没有权限");
        }
        //分页查询
        List<UserVO> listUser = userDao.queryListUserByPage(userInfo);
        return AppResponse.success("查询用户列表成功！", getPageInfo(listUser));
    }

    /**
     * 删除用户
     * @param userInfo
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(UserInfo userInfo){
        //分割字符
        List<String> list = Arrays.asList(userInfo.getUserId().split(","));
        List<String> roleList = Arrays.asList(userInfo.getRole().split(","));
        //查询店长绑定的门店
        List<String> managerIdList = userDao.queryBindStore(list);
        //去除已经绑定门店的店长编号
        List<String> listUserId = new ArrayList<>();
        int j;
        int flag = 0;
        for (int i = 0; i < list.size() && i < roleList.size(); i++) {
            if(userInfo.getNowRole().equals(roleList.get(i))){
                continue;
            }
            for(j = 0; j < managerIdList.size(); j++){
                if(!list.get(i).equals(managerIdList.get(j))){
                    flag++;
                }
            }
            //判断次数是否相同，相同就说明该用户id没和门店绑定了
            if(flag == j){
                listUserId.add(list.get(i));
            }
            flag = 0;
        }
        if(listUserId.size() == 0){
            return AppResponse.versionError("管理员不能删除管理员或该店长已经绑定门店，不能删除");
        }
        int count = userDao.deleteUser(listUserId, userInfo.getUpdateUser());
        if(count == 0){
            return AppResponse.versionError("删除用户失败，请刷新页面");
        }
        return AppResponse.success("删除用户成功");
    }
}
