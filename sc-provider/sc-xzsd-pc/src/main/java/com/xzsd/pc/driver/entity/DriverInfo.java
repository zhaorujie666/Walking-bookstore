package com.xzsd.pc.driver.entity;

import java.util.Date;

/**
 * @Description 司机实体类
 * @Author zhaorujie
 * @Date 2020-03-24
 */
public class DriverInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
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
     *图片上传返回的路径
     */
    private String imagePath;
    /**
     * 显示的头像
     */
    private String userImage;
    /**
     * 身份证
     */
    private String idCard;
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
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;
    /**
     * 司机地址信息表id
     */
    private String driverInfoId;
    /**
     * 登录角色
     */
    private String role;
    /**
     * 登录用户id
     */
    private String loginUserId;
    /**
     * 登录用户的角色
     */
    private String nowRole;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getNowRole() {
        return nowRole;
    }

    public void setNowRole(String nowRole) {
        this.nowRole = nowRole;
    }
}
