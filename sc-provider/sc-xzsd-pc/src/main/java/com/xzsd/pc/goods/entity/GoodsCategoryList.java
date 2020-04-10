package com.xzsd.pc.goods.entity;

import com.xzsd.pc.category.entity.GoodsCategoryVO;

import java.util.List;

public class GoodsCategoryList {
    private List<GoodsCategoryVO> goodsClassifyList;

    public List<GoodsCategoryVO> getGoodsClassifyList() {
        return goodsClassifyList;
    }

    public void setGoodsClassifyList(List<GoodsCategoryVO> goodsClassifyList) {
        this.goodsClassifyList = goodsClassifyList;
    }
}
