package com.xzsd.app.customerorder.entity;

/**
 * @Description 评价图片
 * @author zhaorujie
 * @date 2020/4/14
 */
public class EvaluationImages {
    /**
     * 评价图片id
     */
    private String imageId;
    /**
     * 评价图片url
     */
    private String imagePath;
    /**
     * 图片排序
     */
    private String imageNum;
    /**
     * 评价id
     */
    private String evaluationId;
    /**
     * 用户id
     */
    private String userId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageNum() {
        return imageNum;
    }

    public void setImageNum(String imageNum) {
        this.imageNum = imageNum;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
