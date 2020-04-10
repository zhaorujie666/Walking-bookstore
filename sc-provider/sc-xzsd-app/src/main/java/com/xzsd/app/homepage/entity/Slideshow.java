package com.xzsd.app.homepage.entity;

/**
 * @Description 首页轮播图
 * @author zhaorujie
 * @date 2020/4/9
 */
public class Slideshow {
    /**
     * 首页轮播图的路径
     */
    private String slideshowPath;
    /**
     * 商品id
     */
    private String goodsId;

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
