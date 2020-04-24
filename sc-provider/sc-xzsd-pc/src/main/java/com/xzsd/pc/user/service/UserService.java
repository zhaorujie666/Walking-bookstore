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
        String image = userInfo.getImagePath();
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
        if(!user.getUserAcct().equals(userInfo.getUserAcct()) || !user.getPhone().equals(userInfo.getPhone())){
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
     */
    public AppResponse getListUser(UserInfo userInfo){
        //分页查询
        List<UserVO> listUser = userDao.queryListUserByPage(userInfo);
        return AppResponse.success("查询用户列表成功！", getPageInfo(listUser));
    }

    /**
     * 删除用户
     * @param userId
     * @param loginUserId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId, String loginUserId){
        String userRole = userDao.getUserRole(loginUserId);
        if("2".equals(userRole)){
            return AppResponse.versionError("您没有权限，请获取权限");
        }
        List<String> list = Arrays.asList(userId.split(","));
        List<String> managerIdList = userDao.queryBindStore(list);
        //去除已经绑定门店的店长编号
        List<String> listUserId = new ArrayList<>();
        int j;
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            for(j = 0; j < managerIdList.size(); j++){
                if(!list.get(i).equals(managerIdList.get(j))){
                    flag++;
                }
            }
            //判断次数是否相同，相同就说明该用户id和门店绑定了
            if(flag == j){
                listUserId.add(list.get(i));
            }
            flag = 0;
        }
        if(listUserId.size() == 0){
            return AppResponse.versionError("该店长已经绑定门店，不能删除");
        }
        int count = userDao.deleteUser(listUserId, loginUserId);
        if(count == 0){
            return AppResponse.versionError("删除用户失败，请刷新页面");
        }
        return AppResponse.success("删除用户成功");
    }
}
