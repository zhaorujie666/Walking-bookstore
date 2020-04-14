package com.xzsd.app.managerorder.entity;

import java.util.List;

/**
 * @description 订单
 * @author zhaorujie
 * @date
 */
public class ManagerOrder {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 订单详情id
     */
    private String orderDetailsId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 单个商品购买数量
     */
    private String clientGoodsNum;
    /**
     * 单个商品购买数量乘与商品价格
     */
    private String totalGoodsPrice;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 搜索关键字
     */
    private String keyword;
    /**
     * 一页多少条
     */
    private int pageSize;
    /**
     * 第几页
     */
    private int pageNum;
    /**
     * 商品信息集合
     */
    private List<GoodsInfo> goodsList;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 总购买数
     */
    private int orderAllGoodsCount;
    /**
     * 版本号
     */
    private String version;
    /**
     * 创建时间
     */
    private String crateTime;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 门店id
     */
    private String storeId;
    /**
     * 客户名称
     */
    private String userName;
    /**
     * 客户电话
     */
    private String phone;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(String orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getClientGoodsNum() {
        return clientGoodsNum;
    }

    public void setClientGoodsNum(String clientGoodsNum) {
        this.clientGoodsNum = clientGoodsNum;
    }

    public String getTotalGoodsPrice() {
        return totalGoodsPrice;
    }

    public void setTotalGoodsPrice(String totalGoodsPrice) {
        this.totalGoodsPrice = totalGoodsPrice;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public List<GoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public int getOrderAllGoodsCount() {
        return orderAllGoodsCount;
    }

    public void setOrderAllGoodsCount(int orderAllGoodsCount) {
        this.orderAllGoodsCount = orderAllGoodsCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
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
