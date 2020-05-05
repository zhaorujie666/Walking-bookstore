package com.xzsd.app.customerorder.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.customerorder.dao.OrderDao;
import com.xzsd.app.customerorder.entity.*;
import com.xzsd.app.userinfo.dao.UserInfoDao;
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

    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCustomerOrder(OrderInfo orderInfo){
        //看用户是否绑定了门店邀请码
        String inviteCode = userInfoDao.getUserInviteCode(orderInfo.getUserId());
        if("".equals(inviteCode)){
            return AppResponse.versionError("请先绑定店铺邀请码，再来购买");
        }
        //设置订单id
        orderInfo.setOrderId(StringUtil.getCommonCode(2));
        //分割字符
        List<String> listGoodsId = Arrays.asList(orderInfo.getGoodsId().split(","));
        List<String> listGoodsPrice = Arrays.asList(orderInfo.getGoodsPrice().split(","));
        List<String> listGoodsNum = Arrays.asList(orderInfo.getClientGoodsNum().split(","));
        List<String> shopCartIdList = Arrays.asList(orderInfo.getShopCartId().split(","));
        //查询商品的库存情况
        List<GoodsInfo> listGoodsInventory = orderDao.getListGoodsInventory(listGoodsId);
        List<OrderInfo> orderInfoList = new ArrayList<>();
        int totalGoodsNum = 0;
        double totalGoodsPrice = 0;
        //遍历每一个商品，商品价格和购买数量
        for (int i = 0; i < listGoodsId.size() && i < listGoodsPrice.size() &&  i < listGoodsNum.size(); i++) {
            for(int j = 0; j < listGoodsInventory.size(); j++){
                if(listGoodsId.get(i).equals(listGoodsInventory.get(j).getGoodsId())){
                    //判断当前购买商品的商品是否超过商品的库存数量
                    if(listGoodsInventory.get(j).getGoodsInventory() < Integer.valueOf(listGoodsNum.get(i))){
                        return AppResponse.versionError("当前购买的商品已超过库存，请重新选择购买数量");
                    }
                    //库存数量减去当前购买的数量
                    listGoodsInventory.get(j).setGoodsInventory(listGoodsInventory.get(j).getGoodsInventory() - Integer.valueOf(listGoodsNum.get(i)));
                    //判断商品的库存是否等于0，如果等于0就把商品的状态改为（0：售罄）
                    if(listGoodsInventory.get(j).getGoodsInventory() == 0){
                        listGoodsInventory.get(j).setGoodsStatus("0");
                    }
                }
            }
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
            //计算单个商品的总金额（购买数量 * 商品价格）
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
            return AppResponse.versionError("新增订单失败");
        }
        //更新商品库存，只有库存为0时再更新商品状态
        int goodsInventory = orderDao.updateGoodsInventory(listGoodsInventory);
        if(0 == goodsInventory){
            return AppResponse.versionError("更新商品库存失败");
        }
        //删除购物车,只有购物车id不为0，才删除
        if(!"0".equals(shopCartIdList.get(0))){
            int shoppingCard = orderDao.deleteShoppingCard(shopCartIdList, orderInfo.getUserId());
            if(0 == shoppingCard){
                return AppResponse.versionError("删除购物车失败");
            }
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
        if(pageData.getList().size() == 0){
            return AppResponse.success("该状态下的订单列表为空", pageData);
        }
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
            return AppResponse.versionError("修改订单状态失败");
        }
        //订单状态取消后恢复库存，如果商品状态为售罄恢复为在售
        if("1".equals(orderInfo.getOrderStateId())){
            //查询订单的信息
            OrderInfoVO customerOrder = orderDao.getCustomerOrderById(orderInfo.getOrderId());
            List<GoodsInfo> goodsList = customerOrder.getGoodsList();
            List<String> listGoodsId = new ArrayList<>();
            for (int i = 0; i < goodsList.size(); i++) {
                listGoodsId.add(goodsList.get(i).getGoodsId());
            }
            //查询商品的库存情况
            List<GoodsInfo> listGoodsInventory = orderDao.getListGoodsInventory(listGoodsId);
            for (int i = 0; i < goodsList.size(); i++) {
                for(int j = 0; j < listGoodsInventory.size(); j++){
                    if(goodsList.get(i).getGoodsId().equals(listGoodsInventory.get(j).getGoodsId())){
                        //库存数量加上当前购买的数量
                        listGoodsInventory.get(j).setGoodsInventory(listGoodsInventory.get(j).getGoodsInventory() + goodsList.get(i).getCartGoodsCount());
                        //判断商品的库存是否等于0，如果不等于0就把商品的状态改为（1：在售）
                        if("0".equals(listGoodsInventory.get(j).getGoodsStatus()) && listGoodsInventory.get(j).getGoodsInventory() != 0){
                            listGoodsInventory.get(j).setGoodsStatus("1");
                        }
                    }
                }
            }
            //更新商品库存和销售量，更新商品状态
            int goodsInventory = orderDao.updateGoodsInventory(listGoodsInventory);
            if(0 == goodsInventory){
                return AppResponse.versionError("更新商品库存失败");
            }
        }
        //订单状态确认收货后恢销售量增加
        if("4".equals(orderInfo.getOrderStateId())){
            //查询订单的信息
            OrderInfoVO customerOrder = orderDao.getCustomerOrderById(orderInfo.getOrderId());
            List<GoodsInfo> goodsList = customerOrder.getGoodsList();
            List<String> listGoodsId = new ArrayList<>();
            for (int i = 0; i < goodsList.size(); i++) {
                listGoodsId.add(goodsList.get(i).getGoodsId());
            }
            //查询商品的销售量情况
            List<GoodsInfo> listGoodsInventory = orderDao.getListGoodsInventory(listGoodsId);
            for (int i = 0; i < goodsList.size(); i++) {
                for(int j = 0; j < listGoodsInventory.size(); j++){
                    if(goodsList.get(i).getGoodsId().equals(listGoodsInventory.get(j).getGoodsId())){
                        //商品的销售量加上购买的商品数量
                        listGoodsInventory.get(j).setSales(listGoodsInventory.get(j).getSales() + goodsList.get(i).getCartGoodsCount());
                    }
                }
            }
            //更新商品的销售量
            int goodsInventory = orderDao.updateGoodsInventory(listGoodsInventory);
            if(0 == goodsInventory){
                return AppResponse.versionError("更新商品销售量失败");
            }
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
            return AppResponse.versionError("查询订单详情失败");
        }
        customerOrder.setAddress(customerOrder.getProvinceName() + customerOrder.getCityName() + customerOrder.getAreaName() + customerOrder.getAddress());
        return AppResponse.success("查询订单详情成功", customerOrder);
    }

    /**
     * 查询订单评价列表的商品信息
     * @param orderId
     * @return
     * @author zhaorujie
     * @date 2020/4/13
     */
    public AppResponse getListOrderEvaluation(String orderId){
        List<GoodsInfo> orderEvaluation = orderDao.getListOrderEvaluation(orderId);
        //封装数据
        OrderInfoVO orderInfo= new OrderInfoVO();
        orderInfo.setGoodsList(orderEvaluation);
        return AppResponse.success("查询订单评价列表的商品信息成功", orderInfo);
    }

    /**
     * 订单的商品评价
     * @param obj
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addEvaluateOrder(JSONObject obj, String userId){
        //转成java实体类
        EvaluationOrder evaluationOrder = obj.toJavaObject(EvaluationOrder.class);
        //获取评价商品集合
        List<EvaluationGoods> evaluateList = evaluationOrder.getEvaluateList();
        //评价商品集合
        List<EvaluationOrder> evaluationOrderList = new ArrayList<>();
        //评价商品图片集合
        List<EvaluationImages> evaluationImagesList = new ArrayList<>();
        //商品id集合，为更新商品等级
        List<String> listGoodsId = new ArrayList<>();
        for (int i = 0; i < evaluateList.size(); i++) {
            if(evaluateList.get(i).getEvaluateScore() == 0){
                return AppResponse.versionError("评价等级不能为空");
            }
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
            if(evaluateList.get(i).getImageList() != null){
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
        }
        int count = orderDao.addEvaluateOrder(evaluationOrderList);
        if(0 == count){
            return AppResponse.versionError("新增评价失败");
        }
        //判断有没有传评价图片
        if(evaluationImagesList.size() > 0){
            int num = orderDao.addEvaluateOrderGoodsImages(evaluationImagesList);
            if(0 == num){
                return AppResponse.versionError("新增商品评价图片失败");
            }
        }
        //根据评价商品的id查询该商品的星级平均数
        List<GoodsInfo> goodsInfo = orderDao.getEvaluationGoodsRank(listGoodsId);
        //更新商品的星级
        int rank = orderDao.updateGoodsRank(goodsInfo);
        if(0 == rank){
            return AppResponse.versionError("更新商品等级失败");
        }
        //更新订单状态为已完成已评价
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderStateId("5");
        orderInfo.setOrderId(evaluationOrder.getOrderId());
        orderInfo.setUserId(evaluationOrder.getUserId());
        int flag = orderDao.updateOrderStatus(orderInfo);
        if(0 == flag){
            return AppResponse.versionError("更新订单状态失败");
        }
        return AppResponse.success("新增评价成功");
    }
}
