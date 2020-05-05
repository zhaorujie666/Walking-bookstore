package com.xzsd.pc.goods.entity;

/**
 * @Description 商品详情实体类
 * @author zhaorujie
 * @date 2020-03-28
 */
public class GoodsDetails {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品名
     */
    private String goodsName;
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
     * 一级分类编号
     */
    private String oneClassifyId;
    /**
     * 二级分类编号
     */
    private String twoClassifyId;
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
     * 商品图片
     */
    private String goodsImagePath;
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

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOneClassifyId() {
        return oneClassifyId;
    }

    public void setOneClassifyId(String oneClassifyId) {
        this.oneClassifyId = oneClassifyId;
    }

    public String getTwoClassifyId() {
        return twoClassifyId;
    }

    public void setTwoClassifyId(String twoClassifyId) {
        this.twoClassifyId = twoClassifyId;
    }
}
