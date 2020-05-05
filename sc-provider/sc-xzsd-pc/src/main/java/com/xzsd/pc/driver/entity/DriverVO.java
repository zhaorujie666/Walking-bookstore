package com.xzsd.pc.driver.entity;

/**
 * @Description 司机实体类
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
    private long phone;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 显示的头像
     */
    private String userImage;
    /**
     * 省级编号
     */
    private String provinceId;
    /**
     * 市级编号
     */
    private String cityId;
    /**
     * 区级编号
     */
    private String areaId;
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
    private String version;
    /**
     * 司机地址信息表id
     */
    private String driverInfoId;
    /**
     * 登录用户的角色
     */
    private String newRole;

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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDriverInfoId() {
        return driverInfoId;
    }

    public void setDriverInfoId(String driverInfoId) {
        this.driverInfoId = driverInfoId;
    }

    public String getNewRole() {
        return newRole;
    }

    public void setNewRole(String newRole) {
        this.newRole = newRole;
    }
}
