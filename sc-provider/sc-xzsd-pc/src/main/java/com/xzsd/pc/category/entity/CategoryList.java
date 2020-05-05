package com.xzsd.pc.category.entity;

import java.util.List;

/**
 * @Description 封装数据
 * @author zhaorujie
 * @date 2020-03-26
 */
public class CategoryList {
    /**
     * 封装数据
     */
    private List<GoodsCategoryVO> oneClassifyList;

    public List<GoodsCategoryVO> getOneClassifyList() {
        return oneClassifyList;
    }

    public void setOneClassifyList(List<GoodsCategoryVO> oneClassifyList) {
        this.oneClassifyList = oneClassifyList;
    }
}
