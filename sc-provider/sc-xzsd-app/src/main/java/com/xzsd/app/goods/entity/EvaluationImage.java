package com.xzsd.app.goods.entity;

/**
 * 评价图片实体类
 * @author zhaorujie
 * @date 2020/4/12
 */
public class EvaluationImage {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 评价图片
     */
    private String imagePath;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
