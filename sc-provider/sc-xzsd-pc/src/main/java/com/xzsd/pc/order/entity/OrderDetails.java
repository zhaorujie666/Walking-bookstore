package com.xzsd.pc.order.entity;

/**
 * @Description 订单详情实体类
 * @Author zhaorujie
 * @Date 2020-03-27
 */
public class OrderDetails {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     *单个商品的购买数量
     */
    private int goodsCount;
    /**
     * 商品总价
     */
    private String theGoodsAllPrice;
    /**
     * 商品售价
     */
    private String goodsPrice;
    /**
     * 商品定价
     */
    private String goodsShelfCost;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getTheGoodsAllPrice() {
        return theGoodsAllPrice;
    }

    public void setTheGoodsAllPrice(String theGoodsAllPrice) {
        this.theGoodsAllPrice = theGoodsAllPrice;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsShelfCost() {
        return goodsShelfCost;
    }

    public void setGoodsShelfCost(String goodsShelfCost) {
        this.goodsShelfCost = goodsShelfCost;
    }
}
