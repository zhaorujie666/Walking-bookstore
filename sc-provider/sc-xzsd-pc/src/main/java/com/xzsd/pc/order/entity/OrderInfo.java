package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * @Description 实体类
 * @Author zhaorujie
 * @Date 2020-03-27
 */
public class OrderInfo {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 下单人id
     */
    private String userId;
    /**
     * 登录者Id
     */
    private String loginId;
    /**
     * 支付时间起
     */
    private String defrayTimeStart;
    /**
     * 支付时间止
     */
    private String defrayTimeEnd;
    /**
     * 下单人电话
     */
    private String phone;
    /**
     * 订单状态(0已下单， 1待取货， 2已取货， 3已完成未评价， 4已完成已评价， 5已取消)
     */
    private String orderStatus;
    /**
     * 订单总价
     */
    private String totalPrice;
    /**
     * 支付状态
     */
    private String defrayStatus;
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 支付时间
     */
    private String defrayTime;
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
    private int version;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDefrayTimeStart() {
        return defrayTimeStart;
    }

    public void setDefrayTimeStart(String defrayTimeStart) {
        this.defrayTimeStart = defrayTimeStart;
    }

    public String getDefrayTimeEnd() {
        return defrayTimeEnd;
    }

    public void setDefrayTimeEnd(String defrayTimeEnd) {
        this.defrayTimeEnd = defrayTimeEnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDefrayStatus() {
        return defrayStatus;
    }

    public void setDefrayStatus(String defrayStatus) {
        this.defrayStatus = defrayStatus;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getDefrayTime() {
        return defrayTime;
    }

    public void setDefrayTime(String defrayTime) {
        this.defrayTime = defrayTime;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
