package com.xzsd.app.userinfo.entity;

/**
 * @Description 用户信息实体类
 * @author zhaorujie
 * @date 2020/4/8
 */
public class UserInfo {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 图片上传，专门用来接收上传后返回的路径
     */
    private String imagePath;
    /**
     * 用户头像
     */
    private String userImage;
    /**
     * 角色（2店长，3司机，4客户）
     */
    private String role;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 店长邀请码
     */
    private String inviteCode;
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 市名
     */
    private String cityName;
    /**
     * 区名
     */
    private String areaName;
    /**
     * 地址
     */
    private String address;
    /**
     * 司机电话
     */
    private String phone;
    /**
     * 版本号
     */
    private String version;
    /**
     * 原密码
     */
    private String userPassword;
    /**
     * 新密码
     */
    private String userNewPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNewPassword() {
        return userNewPassword;
    }

    public void setUserNewPassword(String userNewPassword) {
        this.userNewPassword = userNewPassword;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", userImage='" + userImage + '\'' +
                ", role='" + role + '\'' +
                ", storeName='" + storeName + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", version=" + version +
                ", userPassword='" + userPassword + '\'' +
                ", userNewPassword='" + userNewPassword + '\'' +
                '}';
    }
}
