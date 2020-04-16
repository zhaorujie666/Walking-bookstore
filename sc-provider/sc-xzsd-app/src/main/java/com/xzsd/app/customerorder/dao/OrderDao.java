package com.xzsd.app.customerorder.dao;

import com.xzsd.app.customerorder.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 订单增删改查
 * @author zhaorujie
 * @date 2020/4/13
 */
@Mapper
public interface OrderDao {
    /**
     * 新增客户订单的订单信息
     * @param orderInfo
     * @return
     */
    int addCustomerOrder(OrderInfo orderInfo);

    /**
     * 新增客户订单的商品信息
     * @param orderInfoList
     * @return
     */
    int addCustomerOrderGoodsInfo(@Param("orderInfoList") List<OrderInfo> orderInfoList);

    /**
     * 查询订单列表（分页）
     * @param orderInfo
     * @return
     */
    List<OrderInfoVO> getListCustomerOrder(OrderInfo orderInfo);

    /**
     * 查询订单列表下的商品
     * @param orderInfo
     * @return
     */
    List<GoodsInfo> getListOrderGoods(OrderInfo orderInfo);

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderStatus(OrderInfo orderInfo);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    OrderInfoVO getCustomerOrderById(@Param("orderId") String orderId);

    /**
     * 查询订单评价列表
     * @param orderId
     * @return
     */
    List<GoodsInfo> getListOrderEvaluation(@Param("orderId") String orderId);

    /**
     * 新增订单商品评价
     * @param evaluationOrders
     * @return
     */
    int addEvaluateOrder(@Param("evaluationOrders") List<EvaluationOrder> evaluationOrders);

    /**
     * 新增订单商品图片
     * @param evaluationImages
     * @return
     */
    int addEvaluateOrderGoodsImages(@Param("evaluationImages") List<EvaluationImages> evaluationImages);

    /**
     * 查询每个商品的评价等级之和
     * @param listGoodsId
     * @return
     */
    List<GoodsInfo> getEvaluationGoodsRank(@Param("listGoodsId") List<String> listGoodsId);

    /**
     * 更新商品星级
     * @param listGoods
     * @return
     */
    int updateGoodsRank(@Param("listGoods") List<GoodsInfo> listGoods);
}
