package com.xzsd.pc.hot.entity;

/**
 * @Description 实体类
 * @author zhaorujie
 * @date 2020-3-31
 */
public class HotGoodsVO {
    /**
     * 热门商品Id
     */
    private String hotId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 排序
     */
    private int sort;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品售价
     */
    private String sellingPrice;
    /**
     * 商品介绍
     */
    private String goodsIntroduction;
    /**
     * 版本号
     */
    private int version;

    public String getHotId() {
        return hotId;
    }

    public void setHotId(String hotId) {
        this.hotId = hotId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
