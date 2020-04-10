package com.xzsd.app.register.entity;

/**
 * 注册实体类
 * @author zhaorujie
 * @date 2020/4/8
 */
public class Register {
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户性别（0男，1女）
     */
    private String sex;
    /**
     * 电话
     */
    private String phone;
    /**
     * 用户邮箱
     */
    private String mail;
    /**
     * 用户身份证
     */
    private String idCard;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 绑定店长邀请码
     */
    private String inviteCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
