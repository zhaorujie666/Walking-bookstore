package com.xzsd.pc.customer.entity;

/**
 * @Description 客户实体类
 * @Author zhaorujie
 * @Date 2020-03-26
 */
public class CustomerVO {
    /**
     * 客户账号
     */
    private String userAcct;
    /**
     * 客户姓名
     */
    private String userName;
    /**
     * 客户性别：0：男 1：女
     */
    private String sex;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 用户id
     */
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
