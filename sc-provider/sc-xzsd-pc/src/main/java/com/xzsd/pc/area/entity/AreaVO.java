package com.xzsd.pc.area.entity;

/**
 * @Description 实体类
 * @Author zhaorujie
 * @Date 2020-03-24
 */
public class AreaVO {
    /**
     * 区域id
     */
    private String areaId;
    /**
     * 地区名称
     */
    private String areaName;
    /**
     * 父级id
     */
    private String parentId;
    /**
     * 等级
     */
    private int rank;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
