package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 增删改查
 * @author zhaorujie
 * @date 2020-3-30
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表（分页）
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("listOrders")
    public AppResponse getListOrder(OrderInfo orderInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setLoginUserId(userId);
            return orderService.getListOrder(orderInfo);
        }catch (Exception e){
            logger.error("查询订单列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @author zhaorujie
     * @date 2020-3-31
     */
    @PostMapping("getListOrder")
    public AppResponse getOrderDetailsById(String orderId){
        try {
            return orderService.getOrderDetailsById(orderId);
        }catch (Exception e){
            logger.error("查询订单详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUpdateUser(userId);
            orderInfo.setLoginUserId(userId);
            return orderService.updateOrderStatus(orderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败");
            System.out.println(e.toString());
            throw e;
        }

    }
}
