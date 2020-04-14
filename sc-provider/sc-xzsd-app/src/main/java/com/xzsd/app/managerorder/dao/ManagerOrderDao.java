package com.xzsd.app.managerorder.dao;

import com.xzsd.app.managerorder.entity.GoodsInfo;
import com.xzsd.app.managerorder.entity.ManagerOrder;
import com.xzsd.app.managerorder.entity.ManagerOrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 店长订单查改
 * @author zhaorujie
 * @date 2020/4/14
 */
public interface ManagerOrderDao {
    /**
     * 查询店长订单列表
     * @param managerOrder
     * @return
     */
    List<ManagerOrderVO> getListManagerOrder(ManagerOrder managerOrder);

    /**
     * 查询订单下的所有商品
     * @param managerOrder
     * @return
     */
    List<GoodsInfo> getListOrderGoods(ManagerOrder managerOrder);

    /**
     * 更新订单状态
     * @param managerOrder
     * @return
     */
    int updateOrderStatus(ManagerOrder managerOrder);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    ManagerOrderVO getManagerOrderDetailsById(@Param("orderId") String orderId);
}
