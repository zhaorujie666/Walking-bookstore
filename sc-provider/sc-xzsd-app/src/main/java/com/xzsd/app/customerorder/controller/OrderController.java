package com.xzsd.app.customerorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customerorder.entity.OrderInfo;
import com.xzsd.app.customerorder.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.PropertySourcedMapping;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;

/**
 * @Description 客户订单
 * @author zhaorujie
 * @date 2020/4/13
 */
@RestController
@RequestMapping("clientOrder")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @PostMapping("addOrder")
    public AppResponse addCustomerOrder(OrderInfo orderInfo){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUserId(userId);
            return orderService.addCustomerOrder(orderInfo);
        }catch (Exception e){
            logger.error("新增订单失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @PostMapping("listOrder")
    public AppResponse getListCustomerOrder(OrderInfo orderInfo){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUserId(userId);
            return orderService.getListCustomerOrder(orderInfo);
        }catch (Exception e){
            logger.error("查询订单列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUserId(userId);
            return orderService.updateOrderStatus(orderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @PostMapping("listOrderDeepen")
    public AppResponse getCustomerOrderById(String orderId){
        try {
            return orderService.getCustomerOrderById(orderId);
        }catch (Exception e){
            logger.error("查询订单详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单评价列表
     * @param orderId
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @PostMapping("listGoodsForEvaluate")
    public AppResponse getListOrderEvaluation(String orderId){
        try {
            return orderService.getListOrderEvaluation(orderId);
        }catch (Exception e){
            logger.error("查询订单评价列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增订单评价
     * @param
     * @return
     * @author zhaorujie
     * @date 2020/4/14
     */
    @PostMapping("addGoodsEvaluate")
    public AppResponse addEvaluateOrder(@RequestBody JSONObject obj){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            return orderService.addEvaluateOrder(obj, userId);
        }catch (Exception e){
            logger.error("新增订单评价失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
