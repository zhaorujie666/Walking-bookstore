package com.xzsd.pc.goods.entity;

import com.xzsd.pc.category.entity.GoodsCategoryVO;

import java.util.List;

/**
 * 封装数据实体类
 * @author zhaorujie
 * @date
 */
public class GoodsCategoryList {
    /**
     * 封装数据
     */
    private List<GoodsCategoryVO> goodsClassifyList;

    public List<GoodsCategoryVO> getGoodsClassifyList() {
        return goodsClassifyList;
    }

    public void setGoodsClassifyList(List<GoodsCategoryVO> goodsClassifyList) {
        this.goodsClassifyList = goodsClassifyList;
    }
}
