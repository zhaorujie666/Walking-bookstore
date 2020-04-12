package com.xzsd.app.goods.entity;

import java.util.List;

/**
 * @Description 封装数据
 * @author zhaorujie
 * @date 2020/4/12
 */
public class SecondCategoryList {
    /**
     * 商品二级分类集合
     */
    private List<GoodsCategory> towClassifyList;

    public List<GoodsCategory> getTowClassifyList() {
        return towClassifyList;
    }

    public void setTowClassifyList(List<GoodsCategory> towClassifyList) {
        this.towClassifyList = towClassifyList;
    }
}
