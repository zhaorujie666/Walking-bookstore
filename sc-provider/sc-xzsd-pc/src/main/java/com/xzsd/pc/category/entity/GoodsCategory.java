package com.xzsd.pc.category.entity;

import java.util.Date;
import java.util.List;

/**
 * @Description 实体类
 * @Author zhaorujie
 * @Date 2020-03-26
 */
public class GoodsCategory {
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
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private int version;

    /**
     * 二级分类
     */
    private List<GoodsCategory> secondCategoryList;

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<GoodsCategory> getSecondCategoryList() {
        return secondCategoryList;
    }

    public void setSecondCategoryList(List<GoodsCategory> secondCategoryList) {
        this.secondCategoryList = secondCategoryList;
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", rank=" + rank +
                ", parentId='" + parentId + '\'' +
                ", remark='" + remark + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", secondCategoryList=" + secondCategoryList +
                '}';
    }
}
