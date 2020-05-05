package com.xzsd.pc.order.entity;

/**
 * @Description 订单实体类
 * @Author zhaorujie
 * @Date 2020-03-27
 */
public class OrderVO {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 下单人电话
     */
    private String phone;
    /**
     * 订单状态(0已下单， 1待取货， 2已取货， 3已完成未评价， 4已完成已评价， 5已取消)
     */
    private String orderStateId;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 支付时间
     */
    private String payTime;
    /**
     * 版本号
     */
    private String version;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime.replace(".0", "");
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
