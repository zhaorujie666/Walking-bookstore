package com.xzsd.pc.user.entity;

/**
 * @Description 用户实体类
 * @Author zhaorujie
 * @Date 2020-03-27
 */
public class UserInfo {
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
     * 图片上传返回的路径
     */
    private String imagePath;
    /**
     * 用户头像
     */
    private String userImage;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机
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
     * 角色（0超级管理员，1管理员，2店长，3司机，4用户）
     */
    private String role;
    /**
     * 邀请码
     */
    private String invitationCode;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
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
    private String createTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 版本号
     */
    private String version;
    /**
     * 登录用户的角色
     */
    private String nowRole;

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

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNowRole() {
        return nowRole;
    }

    public void setNowRole(String nowRole) {
        this.nowRole = nowRole;
    }
}
