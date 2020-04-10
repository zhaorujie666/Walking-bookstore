package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderDetailsList;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description OrderDao实现类
 * @author zhaorujie
 * @date 2020-3-30
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;
    
    @Resource
    private UserDao userDao;

    /**
     * 查询订单列表（分页）
     * @param orderInfo
     * @param userId
     * @return
     */
    public AppResponse getListOrder(OrderInfo orderInfo, String userId){
        //判断是否为管理员
        String loginRole = userDao.getUserRole(userId);
        List<OrderVO> listOrder;
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        if("0".equals(loginRole) == false){
            listOrder = orderDao.getListOrder(orderInfo);
        }else{
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
        if(orderDetails.size() == 0){
            return AppResponse.bizError("查询订单详情失败！");
        }
        //封装成接口文档需要的名称
        OrderDetailsList orderDetailsList = new OrderDetailsList();
        orderDetailsList.setOrderList(orderDetails);
        return AppResponse.success("查询订单详情成功！", orderDetailsList);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo, String userId){
        String loginRole = userDao.getUserRole(userId);
        //判断只有店长才能修改订单
        if("1".equals(loginRole) == false){
            return AppResponse.bizError("您不能修改订单状态，只有店长才可以！");
        }
        int count = orderDao.updateOrderStatus(orderInfo);
        if(count == 0){
            return AppResponse.bizError("更新订单状态失败");
        }
        return AppResponse.success("更新订单状态成功");
    }
}
