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
    private String driverAccount;
    /**
     * 密码
     */
    private String password;
    /**
     * 司机姓名
     */
    private String driverName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 身份证
     */
    private String idCard;
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
    private String countryName;
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

    public String getDriverAccount() {
        return driverAccount;
    }

    public void setDriverAccount(String driverAccount) {
        this.driverAccount = driverAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
