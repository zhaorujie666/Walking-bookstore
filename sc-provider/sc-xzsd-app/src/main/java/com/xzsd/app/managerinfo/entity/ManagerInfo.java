package com.xzsd.app.managerinfo.entity;

/**
 * @Description 负责给店长送货司机实体类
 * @author zhaorujie
 * @date 2020/4/14
 */
public class ManagerInfo {
    /**
     * 店长id
     */
    private String userId;
    /**
     * 司机姓名
     */
    private String userName;
    /**
     * 司机电话
     */
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
