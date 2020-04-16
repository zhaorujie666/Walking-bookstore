package com.xzsd.app.customerorder.entity;

import java.util.List;

/**
 * @Description 评价的订单
 * @author zhaorujie
 * @date 2020/4/14
 */
public class EvaluationOrder {
    /**
     * 评价id
     */
    private String evaluationId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 评价商品集合
     */
    private List<EvaluationGoods> evaluateList;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价星级
     */
    private int evaluateScore;

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<EvaluationGoods> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<EvaluationGoods> evaluateList) {
        this.evaluateList = evaluateList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }
}
