package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverDetails;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DriverDao
 * @Description Driver
 * @author zhaorujie
 * @date 2020-03-24
 */
@Mapper
public interface DriverDao {
    /**
     * 统计司机账号和手机号是否存在
     * @param driverInfo
     * @return
     */
    int countDriverAccountAndPhone(DriverInfo driverInfo);

    /**
     * 新增司机
     * @param driverInfo
     * @return
     */
    int addDriver(DriverInfo driverInfo);

    /**
     * 新增司机地址信息
     * @param driverInfo
     * @return
     */
    int addDriverArea(DriverInfo driverInfo);

    /**
     * 查询司机信息
     * @param driverId
     * @return
     */
    DriverVO getDriverById(@Param("driverId") String driverId);

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 修改司机地区信息
     * @param driverInfo
     * @return
     */
    int updateDriverArea(DriverInfo driverInfo);

    /**
     *管理员查询所有的司机信息
     * @param driverInfo
     * @return 司机信息
     */
    List<DriverVO> getListDriverByAdmin(DriverInfo driverInfo);

    /**
     * 查询当前店长下的所有司机
     * @param driverInfo
     * @return
     */
    List<DriverVO> getListDriverByStore(DriverInfo driverInfo);

    /**
     * 删除司机
     * @param listDriverId
     * @param loginId
     * @return
     */
    int deleteDriverById(@Param("listDriverId") List<String> listDriverId, @Param("loginId") String loginId);

    /**
     * 删除司机地区
     * @param listDriverId
     * @param loginId
     * @return
     */
    int deleteDriverAreaById(@Param("listDriverId") List<String> listDriverId, @Param("loginId") String loginId);
}
