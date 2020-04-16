package com.xzsd.app.customerorder.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.customerorder.dao.OrderDao;
import com.xzsd.app.customerorder.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 订单业务逻辑层
 * @author zhaorujie
 * @date 2020/4/13
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCustomerOrder(OrderInfo orderInfo){
        //设置订单id
        orderInfo.setOrderId(StringUtil.getCommonCode(2));
        //分割字符
        List<String> listGoodsId = Arrays.asList(orderInfo.getGoodsId().split(","));
        List<String> listGoodsPrice = Arrays.asList(orderInfo.getGoodsPrice().split(","));
        List<String> listGoodsNum = Arrays.asList(orderInfo.getClientGoodsNum().split(","));
        List<OrderInfo> orderInfoList = new ArrayList<>();
        int totalGoodsNum = 0;
        double totalGoodsPrice = 0;
        //遍历每一个商品，商品价格和购买数量
        for (int i = 0; i < listGoodsId.size() && i < listGoodsPrice.size() &&  i< listGoodsNum.size(); i++) {
            //计算订单总购买数
            totalGoodsNum = totalGoodsNum + Integer.valueOf(listGoodsNum.get(i));
            //计算订单总价格
            totalGoodsPrice = totalGoodsPrice + Double.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsNum.get(i));
            OrderInfo order = new OrderInfo();
            //设置订单详情表Id
            order.setOrderDetailsId(StringUtil.getCommonCode(2));
            //设置订单id
            order.setOrderId(orderInfo.getOrderId());
            //设置商品id
            order.setGoodsId(listGoodsId.get(i));
            order.setUserId(orderInfo.getUserId());
            //设置单个商品的购买数量
            order.setClientGoodsNum(listGoodsNum.get(i));
            //设置单个商品的购买数量乘与商品价格
            Double totalPrice = Double.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsNum.get(i));
            order.setTotalGoodsPrice(String.valueOf(totalPrice));
            orderInfoList.add(order);
        }
        //设置订单总数
        orderInfo.setOrderAllGoodsCount(totalGoodsNum);
        //设置订单总价
        orderInfo.setOrderAllCost(String.valueOf(totalGoodsPrice));
        int count = orderDao.addCustomerOrder(orderInfo);
        int num = orderDao.addCustomerOrderGoodsInfo(orderInfoList);
        if(0 == count || 0 == num){
            return AppResponse.bizError("新增订单失败");
        }
        return AppResponse.success("新增订单成功");
    }

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    public AppResponse getListCustomerOrder(OrderInfo orderInfo){
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfoVO> listCustomerOrder = orderDao.getListCustomerOrder(orderInfo);
        PageInfo<OrderInfoVO> pageData = new PageInfo<>(listCustomerOrder);
        //查询订单列表下的商品
        List<GoodsInfo> listOrderGoods = orderDao.getListOrderGoods(orderInfo);
        for (int i = 0; i < listCustomerOrder.size(); i++) {
            List<GoodsInfo> list = new ArrayList<>();
            for(int j = 0; j < listOrderGoods.size(); j++){
                //判断当前用户下的订单id是否相等
                if(listCustomerOrder.get(i).getOrderId().equals(listOrderGoods.get(j).getOrderId())){
                    list.add(listOrderGoods.get(j));
                }
            }
            pageData.getList().get(i).setGoodsList(list);
        }
        return AppResponse.success("查询订单列表成功", pageData);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        int count = orderDao.updateOrderStatus(orderInfo);
        if(0 == count){
            return AppResponse.bizError("修改订单状态失败");
        }
        return AppResponse.success("修改订单状态成功");
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    public AppResponse getCustomerOrderById(String orderId){
        OrderInfoVO customerOrder = orderDao.getCustomerOrderById(orderId);
        if(null == customerOrder){
            return AppResponse.bizError("查询订单详情失败");
        }
        customerOrder.setAddress(customerOrder.getProvinceName() + customerOrder.getCityName() + customerOrder.getAreaName() + customerOrder.getAddress());
        return AppResponse.success("查询订单详情成功", customerOrder);
    }

    /**
     * 查询订单评价列表
     * @param orderId
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    public AppResponse getListOrderEvaluation(String orderId){
        List<GoodsInfo> orderEvaluation = orderDao.getListOrderEvaluation(orderId);
        if(orderEvaluation.size() == 0){
            return AppResponse.bizError("查询订单评价列表失败");
        }
        OrderInfoVO orderInfo= new OrderInfoVO();
        orderInfo.setGoodsList(orderEvaluation);
        return AppResponse.success("查询订单评价列表成功", orderInfo);
    }

    /**
     * 新增订单商品评价
     * @param obj
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addEvaluateOrder(JSONObject obj, String userId){
        //转成java实体类
        EvaluationOrder evaluationOrder = obj.toJavaObject(EvaluationOrder.class);
        //评价商品集合
        List<EvaluationOrder> evaluationOrderList = new ArrayList<>();
        //评价商品图片集合
        List<EvaluationImages> evaluationImagesList = new ArrayList<>();
        //获取评价商品集合
        List<EvaluationGoods> evaluateList = evaluationOrder.getEvaluateList();
        //商品id集合，为更新商品等级
        List<String> listGoodsId = new ArrayList<>();
        for (int i = 0; i < evaluateList.size(); i++) {
            EvaluationOrder evaluationOrderInfo = new EvaluationOrder();
            //设置评价id
            String evaluationId = StringUtil.getCommonCode(2);
            evaluationOrderInfo.setEvaluationId(evaluationId);
            //设置订单id
            evaluationOrderInfo.setOrderId(evaluationOrder.getOrderId());
            //设置评价人
            evaluationOrderInfo.setUserId(userId);
            //设置商品id
            evaluationOrderInfo.setGoodsId(evaluateList.get(i).getGoodsId());
            listGoodsId.add(evaluateList.get(i).getGoodsId());
            //设置是商品等级
            evaluationOrderInfo.setEvaluateScore(evaluateList.get(i).getEvaluateScore());
            //设置评价内容
            evaluationOrderInfo.setEvaluateContent(evaluateList.get(i).getEvaluateContent());
            evaluationOrderList.add(evaluationOrderInfo);
            List<EvaluationImages> imageList = evaluateList.get(i).getImageList();
            for(int j = 0; j < imageList.size(); j++){
                EvaluationImages evaluationImages = new EvaluationImages();
                //设置商品评价图片表id
                evaluationImages.setImageId(StringUtil.getCommonCode(2));
                //设置图片排序
                evaluationImages.setImageNum(imageList.get(j).getImageNum());
                //设置图片路径
                evaluationImages.setImagePath(imageList.get(j).getImagePath());
                //设置评价表id
                evaluationImages.setEvaluationId(evaluationId);
                //设置用户id
                evaluationImages.setUserId(userId);
                evaluationImagesList.add(evaluationImages);
            }
        }
        int count = orderDao.addEvaluateOrder(evaluationOrderList);
        int num = orderDao.addEvaluateOrderGoodsImages(evaluationImagesList);
        if(0 == count || 0 == num){
            return AppResponse.bizError("新增评价失败");
        }
        //根据评价商品的id查询该商品的星级平均数
        List<GoodsInfo> goodsInfo = orderDao.getEvaluationGoodsRank(listGoodsId);
        //更新商品的星级
        int rank = orderDao.updateGoodsRank(goodsInfo);
        if(0 == rank){
            return AppResponse.bizError("更新商品等级失败");
        }
        return AppResponse.success("新增评价成功");
    }
}
