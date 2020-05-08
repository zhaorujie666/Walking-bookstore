package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderDetailsList;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description OrderDao订单的实现类
 * @author zhaorujie
 * @date 2020-3-30
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 查询订单列表（分页）
     * @param orderInfo
     * @return
     */
    public AppResponse getListOrder(OrderInfo orderInfo){
        List<OrderVO> listOrder = null;
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        //店长查自己的订单，管理员查全部
        if("2".equals(orderInfo.getRole())){
            listOrder = orderDao.getListOrder(orderInfo);
        }else if("0".equals(orderInfo.getRole()) || "1".equals(orderInfo.getRole())){
            listOrder = orderDao.getListOrderByAdmin(orderInfo);
        }
        PageInfo<OrderVO> pageData = new PageInfo<>(listOrder);
        return AppResponse.success("查询订单列表成功！", pageData);
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    public AppResponse getOrderDetailsById(String orderId){
        List<OrderDetails> orderDetails = orderDao.getOrderDetailsById(orderId);
        //封装成接口文档需要的名称
        OrderDetailsList orderDetailsList = new OrderDetailsList();
        orderDetailsList.setOrderDeepenList(orderDetails);
        return AppResponse.success("查询订单详情成功！", orderDetailsList);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        //分割字符
        List<String> listOrderId = Arrays.asList(orderInfo.getOrderId().split(","));
        List<String> listVersion = Arrays.asList(orderInfo.getVersion().split(","));
        //查询当前要修改的订单状态
        List<OrderVO> listOrderStatus = orderDao.getListOrderStatus(listOrderId);
        List<OrderInfo> orderList = new ArrayList<>();
        int flag = 0;
        int cnt = 0;
        for (int i = 0; i < listOrderId.size() && i < listVersion.size(); i++) {
            for(int j = 0; j < listOrderStatus.size(); j++){
                if(listOrderId.get(i).equals(listOrderStatus.get(j).getOrderId())){
                    //如果当前要删除的订单状态为4已完成未评价或5已完成已评价就不让修改订单状态，已完成的订单不能再改了
                    if("4".equals(listOrderStatus.get(j).getOrderStateId()) || "5".equals(listOrderStatus.get(j).getOrderStateId())){
                        cnt++;
                        continue;
                    }
                    if("0".equals(listOrderStatus.get(j).getOrderStateId()) && "3".equals(orderInfo.getOrderStateId())){
                        flag++;
                        continue;
                    }
                    OrderInfo order = new OrderInfo();
                    order.setOrderId(listOrderId.get(i));
                    order.setVersion(listVersion.get(i));
                    order.setOrderStateId(orderInfo.getOrderStateId());
                    order.setUpdateUser(orderInfo.getUpdateUser());
                    orderList.add(order);
                }
            }
        }
        if(orderList.size() == 0 && cnt != 0){
            return AppResponse.versionError("当前订单状态为已完成，不能再修改订单状态");
        }else if(orderList.size() == 0 && flag != 0){
            return AppResponse.versionError("当前订单状态为已下单，不能直接把订单改为已取货");
        }
        int count = orderDao.updateOrderStatus(orderList);
        if(count == 0){
            return AppResponse.versionError("更新订单状态失败");
        }
        return AppResponse.success("更新订单状态成功");
    }
}
