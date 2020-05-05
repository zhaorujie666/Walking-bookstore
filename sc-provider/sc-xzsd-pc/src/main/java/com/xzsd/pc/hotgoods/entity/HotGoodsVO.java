package com.xzsd.pc.hotgoods.entity;

/**
 * @Description 热门商品实体类
 * @author zhaorujie
 * @date 2020-3-31
 */
public class HotGoodsVO {
    /**
     * 热门商品Id
     */
    private String hotGoodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 排序
     */
    private int hotGoodsNum;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品售价
     */
    private String goodsPrice;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 版本号
     */
    private String version;

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getHotGoodsNum() {
        return hotGoodsNum;
    }

    public void setHotGoodsNum(int hotGoodsNum) {
        this.hotGoodsNum = hotGoodsNum;
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

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
