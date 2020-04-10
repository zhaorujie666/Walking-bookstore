package com.xzsd.pc.goods.entity;

/**
 * @Description 商品详情实体类
 * @Author zhaorujie
 * @Date 2020-03-28
 */
public class GoodsVTO {
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
    private String storeName;
    /**
     * 定价
     */
    private String oldPrice;
    /**
     * 售价
     */
    private String sellingPrice;
    /**
     * 一级分类名
     */
    private String firstCategoryName;
    /**
     * 二级分类名
     */
    private String secondCategoryName;
    /**
     * 广告词
     */
    private String advertisement;
    /**
     * 商品介绍
     */
    private String goodsIntroduction;
    /**
     * 库存
     */
    private int stock;
    /**
     * 书号
     */
    private String bookNumber;
    /**
     * 出版社
     */
    private String publisher;
    /**
     * 作者
     */
    private String author;
    /**
     * 商品图片
     */
    private String goodsImage;

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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getFirstCategoryName() {
        return firstCategoryName;
    }

    public void setFirstCategoryName(String firstCategoryName) {
        this.firstCategoryName = firstCategoryName;
    }

    public String getSecondCategoryName() {
        return secondCategoryName;
    }

    public void setSecondCategoryName(String secondCategoryName) {
        this.secondCategoryName = secondCategoryName;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    @Override
    public String toString() {
        return "GoodsVTO{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", sellingPrice='" + sellingPrice + '\'' +
                ", firstCategoryName='" + firstCategoryName + '\'' +
                ", secondCategoryName='" + secondCategoryName + '\'' +
                ", advertisement='" + advertisement + '\'' +
                ", goodsIntroduction='" + goodsIntroduction + '\'' +
                ", stock=" + stock +
                ", bookNumber='" + bookNumber + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                '}';
    }
}
