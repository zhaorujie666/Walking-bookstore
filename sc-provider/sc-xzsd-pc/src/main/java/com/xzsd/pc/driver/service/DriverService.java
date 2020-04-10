package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author zhaorujie
 * @Date 2020-03-24
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    @Resource
    private UserDao userDao;

    /**
     * demo 新增用户
     * @param driverInfo
     * @return
     * @Author zhaorujie
     * @Date 2020-03-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo){
        // 校验司机账号和手机号是否存在
        int countDriverAccount = driverDao.countDriverAccount(driverInfo);
        if(countDriverAccount != 0){
            return AppResponse.bizError("账号或手机号已存在，请重新输入");
        }
        // 校验手机号是否存在
        /*int countPhone = driverDao.countPhone(driverInfo);
        if(0 != countPhone){
            return AppResponse.bizError("手机号已存在，请重新输入");
        }*/
        driverInfo.setDriverId(StringUtil.getCommonCode(2));
        driverInfo.setIsDelete(0);
        driverInfo.setDriverInfoId(StringUtil.getCommonCode(2));
        //密码加密
        String password = driverInfo.getUserPassword();
        String pwd = PasswordUtils.generatePassword(password);
        driverInfo.setUserPassword(pwd);
        //新增司机
        int count = driverDao.addDriver(driverInfo);
        int num = driverDao.addDriverArea(driverInfo);
        if(count == 0 && num == 0){
            return AppResponse.bizError("新增失败！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询司机详情
     * @param driverId
     * @return
     * @Author zhaorujie
     * @Date 2020-03-24
     */
    DriverVO globalDriverInfo = null;
    public AppResponse getDriverById(String driverId){
        globalDriverInfo = driverDao.getDriverById(driverId);
        if(globalDriverInfo == null){
            return AppResponse.bizError("查询失败");
        }
        //查询省市区名称
        List<String> listAreaName = driverDao.getListAreaName(driverId);
        //再对省市区赋值
        globalDriverInfo.setProvinceName(listAreaName.get(0));
        globalDriverInfo.setCityName(listAreaName.get(1));
        globalDriverInfo.setAreaName(listAreaName.get(2));
        return AppResponse.success("查询成功", globalDriverInfo);
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     * @Author zhaorujie
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo){
        //校验账号是否存在
        int count = driverDao.countDriverAccount(driverInfo);
        //判断当前账号是否是当前要修改的账号
        if(count != 0 && globalDriverInfo.getUserAcct().equals(driverInfo.getUserAcct()) == false){
            return AppResponse.bizError("该司机账号已存在，请重新输入！");
        }
        // 校验手机号是否存在
        int countPhone = driverDao.countPhone(driverInfo);
        if(0 != countPhone && globalDriverInfo.getPhone().equals(driverInfo.getPhone()) == false){
            return AppResponse.bizError("手机号已存在，请重新输入");
        }
        //判断密码有没有修改
        if(globalDriverInfo.getUserPassword().equals(driverInfo.getUserPassword()) == false){
            //密码加密
            String password = driverInfo.getUserPassword();
            String pwd = PasswordUtils.generatePassword(password);
            driverInfo.setUserPassword(pwd);
        }
        //修改司机信息
        int driver = driverDao.updateDriver(driverInfo);
        int driverArea = driverDao.updateDriverArea(driverInfo);
        if(driver == 0 && driverArea == 0) {
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 查询司机列表（分页）
     * @param driverInfo
     * @return
     * @Author zhaorujie
     * @Date 2020-03-25
     */
    public AppResponse getListDriver(DriverInfo driverInfo){
        PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
        List<DriverVO> listDriver = null;
        if("2".equals(driverInfo.getRole())){
            listDriver = driverDao.getListDriverByStore(driverInfo);
        }else if("0".equals(driverInfo.getRole()) || "1".equals(driverInfo.getRole())){
            listDriver = driverDao.getListDriverByAdmin(driverInfo);
        }

        PageInfo<DriverVO> pageData = new PageInfo<DriverVO>(listDriver);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除司机信息
     * @param driverId
     * @return
     * @Author zhaorujie
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriverById(String driverId, String loginId){
        List<String> listDriverId = Arrays.asList(driverId.split(","));
        int count = driverDao.deleteDriverById(listDriverId, loginId);
        int num = driverDao.deleteDriverAreaById(listDriverId, loginId);
        if(count == 0 && num == 0){
            return AppResponse.success("删除失败！");
        }
        return AppResponse.success("删除成功！");
    }
}
