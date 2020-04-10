package com.xzsd.pc.category.entity;

/**
 * @Description 实体类
 * @Author zhaorujie
 * @Date 2020-03-26
 */
public class SecondCategoryVO {
    /**
     * 分类id
     */
    private String categoryId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 等级
     */
    private int rank;
    /**
     * 父级id
     */
    private String parentId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 版本号
     */
    private int version;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
