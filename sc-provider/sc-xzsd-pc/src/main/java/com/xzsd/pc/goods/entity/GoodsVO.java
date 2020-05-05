package com.xzsd.pc.goods.entity;

/**
 * @Description 商品列表实体类
 * @Author zhaorujie
 * @Date 2020-03-24
 */
public class GoodsVO {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 商家编码
     */
    private String storeId;
    /**
     * 商家名称
     */
    private String supplierName;
    /**
     * 定价
     */
    private double goodsOriginalCost;
    /**
     * 售价
     */
    private double goodsPrice;
    /**
     * 销售量
     */
    private int goodsSales;
    /**
     * 一级分类名称
     */
    private String oneClassifyName;
    /**
     * 二级分类名称
     */
    private String twoClassifyName;
    /**
     * 广告词
     */
    private String goodsAdvertise;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 商品状态
     */
    private String goodsStateId;
    /**
     * 上架时间
     */
    private String goodsShelfTime;
    /**
     * 浏览量
     */
    private int goodsViewsNum;
    /**
     * 库存
     */
    private int goodsInventory;
    /**
     * 书号
     */
    private String isbn;
    /**
     * 出版社
     */
    private String goodsPress;
    /**
     * 作者
     */
    private String goodsAuthor;
    /**
     * 版本号
     */
    private String version;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public double getGoodsOriginalCost() {
        return goodsOriginalCost;
    }

    public void setGoodsOriginalCost(double goodsOriginalCost) {
        this.goodsOriginalCost = goodsOriginalCost;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(int goodsSales) {
        this.goodsSales = goodsSales;
    }

    public String getOneClassifyName() {
        return oneClassifyName;
    }

    public void setOneClassifyName(String oneClassifyName) {
        this.oneClassifyName = oneClassifyName;
    }

    public String getTwoClassifyName() {
        return twoClassifyName;
    }

    public void setTwoClassifyName(String twoClassifyName) {
        this.twoClassifyName = twoClassifyName;
    }

    public String getGoodsAdvertise() {
        return goodsAdvertise;
    }

    public void setGoodsAdvertise(String goodsAdvertise) {
        this.goodsAdvertise = goodsAdvertise;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsStateId() {
        return goodsStateId;
    }

    public void setGoodsStateId(String goodsStateId) {
        this.goodsStateId = goodsStateId;
    }

    public String getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(String goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime.replace(".0", "");
    }

    public int getGoodsViewsNum() {
        return goodsViewsNum;
    }

    public void setGoodsViewsNum(int goodsViewsNum) {
        this.goodsViewsNum = goodsViewsNum;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
