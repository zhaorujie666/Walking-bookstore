package com.xzsd.pc.store.entity;

/**
 * @Description 门店实体类
 * @Author zhaorujie
 * @Date 2020-03-24
 */
public class StoreVO {
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 店长编码
     */
    private String userId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 营业执照编码
     */
    private String businessCode;
    /**
     * 店长名称
     */
    private String userName;
    /**
     * 电话
     */
    private long phone;
    /**
     * 邀请码
     */
    private String inviteCode;
    /**
     * 门店账号
     */
    private String userAcct;
    /**
     * 省级编号
     */
    private String provinceId;
    /**
     * 城市级编号
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
     * 地址
     */
    private String address;
    /**
     * 版本号
     */
    private String version;
    /**
     * 登录用户的角色
     */
    private String newRole;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
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

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNewRole() {
        return newRole;
    }

    public void setNewRole(String newRole) {
        this.newRole = newRole;
    }
}
