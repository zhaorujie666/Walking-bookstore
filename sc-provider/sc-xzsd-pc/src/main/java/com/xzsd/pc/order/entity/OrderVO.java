package com.xzsd.pc.order.entity;

/**
 * @Description 实体类
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
     * 版本号
     */
    private int version;

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
