package com.xzsd.pc.slide.entity;

/**
 * @Description 轮播图实体类
 * @Author zhaorujie
 * @Date 2020-03-29
 */
public class SlideVO {
    /**
     * 轮播图id
     */
    private String slideshowId;
    /**
     * 轮播图图片
     */
    private String slideshowPath;
    /**
     * 排序
     */
    private int slideshowNum;
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
    private String slideshowStateId;
    /**
     * 版本号
     */
    private String version;

    public String getSlideshowId() {
        return slideshowId;
    }

    public void setSlideshowId(String slideshowId) {
        this.slideshowId = slideshowId;
    }

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

    public int getSlideshowNum() {
        return slideshowNum;
    }

    public void setSlideshowNum(int slideshowNum) {
        this.slideshowNum = slideshowNum;
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

    public String getSlideshowStateId() {
        return slideshowStateId;
    }

    public void setSlideshowStateId(String slideshowStateId) {
        this.slideshowStateId = slideshowStateId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
