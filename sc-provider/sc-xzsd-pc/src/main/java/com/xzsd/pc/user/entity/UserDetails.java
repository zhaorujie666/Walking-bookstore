package com.xzsd.pc.user.entity;

/**
 * @Description 用户详情实体类
 * @Author zhaorujie
 * @Date 2020-03-27
 */
public class UserDetails {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户头像
     */
    private String userImage;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话
     */
    private long phone;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 角色（0管理员，1店长，2司机，3用户）
     */
    private String role;
    /**
     * 版本号
     */
    private String version;
    /**
     * 登录用户的角色
     */
    private String newRole;

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

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
