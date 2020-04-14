package com.xzsd.app.managerorder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.managerorder.dao.ManagerOrderDao;
import com.xzsd.app.managerorder.entity.GoodsInfo;
import com.xzsd.app.managerorder.entity.ManagerOrder;
import com.xzsd.app.managerorder.entity.ManagerOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 店长订单查改
 * @author zhaorujie
 * @date 2020/4/14
 */
@Service
public class ManagerOrderService {
    @Resource
    private ManagerOrderDao managerOrderDao;

    /**
     * 查询店长订单列表（分页）
     * @param managerOrder
     * @return
     * @author zhaorujie
     * @date 2020/4/14
     */
    public AppResponse getListMangerOrder(ManagerOrder managerOrder){
        PageHelper.startPage(managerOrder.getPageNum(), managerOrder.getPageSize());
        List<ManagerOrderVO> listMangerOrder = managerOrderDao.getListManagerOrder(managerOrder);
        List<GoodsInfo> listOrderGoods = managerOrderDao.getListOrderGoods(managerOrder);
        PageInfo<ManagerOrderVO> pageData = new PageInfo<>(listMangerOrder);
        for (int i = 0; i < listMangerOrder.size(); i++) {
            List<GoodsInfo> list = new ArrayList<>();
            for(int j = 0; j < listOrderGoods.size(); j++){
                //判断查出来的订单id是否相等
                if(listMangerOrder.get(i).getOrderId().equals(listOrderGoods.get(j).getOrderId())){
                    list.add(listOrderGoods.get(j));
                }
            }
            listMangerOrder.get(i).setGoodsList(list);
        }
        return AppResponse.success("查询店长订单列表成功", pageData);
    }

    /**
     * 修改订单状态
     * @param managerOrder
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(ManagerOrder managerOrder){
        int count = managerOrderDao.updateOrderStatus(managerOrder);
        if(count == 0){
            return AppResponse.bizError("修改订单状态失败");
        }
        return AppResponse.success("修改订单状态成功");
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    public AppResponse getManagerOrderDetailsById(String orderId){
        ManagerOrderVO orderDetails = managerOrderDao.getManagerOrderDetailsById(orderId);
        if(orderDetails == null){
            return AppResponse.bizError("查询订单详情失败");
        }
        orderDetails.setAddress(orderDetails.getProvinceName() + orderDetails.getCityName() + orderDetails.getAreaName() + orderDetails.getAddress());
        return AppResponse.success("查询订单详情成功", orderDetails);
    }
}
