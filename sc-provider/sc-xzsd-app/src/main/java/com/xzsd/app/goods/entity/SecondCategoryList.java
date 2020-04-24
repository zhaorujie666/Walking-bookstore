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
    private List<GoodsCategory> twoClassifyList;

    public List<GoodsCategory> getTwoClassifyList() {
        return twoClassifyList;
    }

    public void setTwoClassifyList(List<GoodsCategory> twoClassifyList) {
        this.twoClassifyList = twoClassifyList;
    }
}
