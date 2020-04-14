package com.xzsd.app.managerinfo.entity;

import java.util.List;

/**
 * @Description 封装数据
 * @author zhaorujie
 * @date 2020/4/14
 */
public class ManagerInfoList {
    /**
     * 司机信息集合
     */
    private List<ManagerInfo> list;

    public List<ManagerInfo> getList() {
        return list;
    }

    public void setList(List<ManagerInfo> list) {
        this.list = list;
    }
}
