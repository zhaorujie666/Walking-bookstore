package com.xzsd.pc.driver.entity;

/**
 * @Description 实体类
 * @Author zhaorujie
 * @Date 2020-03-24
 */
public class DriverVO {
    /**
     * 司机编码
     */
    private String driverId;
    /**
     * 司机账号
     */
    private String userAcct;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 司机姓名
     */
    private String userName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 显示的头像
     */
    private String userImage;
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 城市名
     */
    private String cityName;
    /**
     * 区县名
     */
    private String areaName;
    /**
     * 版本号
     */
    private int version;
    /**
     * 司机地址信息表id
     */
    private String driverInfoId;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDriverInfoId() {
        return driverInfoId;
    }

    public void setDriverInfoId(String driverInfoId) {
        this.driverInfoId = driverInfoId;
    }
}
