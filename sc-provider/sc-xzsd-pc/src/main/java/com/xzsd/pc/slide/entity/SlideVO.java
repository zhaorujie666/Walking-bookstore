package com.xzsd.pc.slide.entity;

/**
 * @Description 实体类
 * @Author zhaorujie
 * @Date 2020-03-29
 */
public class SlideVO {
    /**
     * 轮播图id
     */
    private String slideId;
    /**
     * 轮播图图片
     */
    private String slideImage;
    /**
     * 排序
     */
    private int sort;
    /**
     * 有效期起
     */
    private String startTime;
    /**
     * 有效期止
     */
    private String endTime;
    /**
     * 轮播图状态
     */
    private String slideStatus;

    public String getSlideId() {
        return slideId;
    }

    public void setSlideId(String slideId) {
        this.slideId = slideId;
    }

    public String getSlideImage() {
        return slideImage;
    }

    public void setSlideImage(String slideImage) {
        this.slideImage = slideImage;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSlideStatus() {
        return slideStatus;
    }

    public void setSlideStatus(String slideStatus) {
        this.slideStatus = slideStatus;
    }

}
