package com.xzsd.app.shoppingcart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.shoppingcart.entity.ShoppingCart;
import com.xzsd.app.shoppingcart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 购物车增删改查
 * @author zhaorujie
 * @date 2020/4/12
 */
@RestController
@RequestMapping("/clientShopCart")
public class ShoppingCartController {
    public static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 新增购物车
     * @param shoppingCart
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ShoppingCart shoppingCart){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCart.setUserId(userId);
            return shoppingCartService.addShoppingCart(shoppingCart);
        }catch (Exception e){
            logger.error("新增购物车失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询购物车列表
     * @param shoppingCart
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("listShoppingCarts")
    public AppResponse getListShoppingCart(ShoppingCart shoppingCart){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCart.setUserId(userId);
            return shoppingCartService.getListShoppingCart(shoppingCart);
        }catch (Exception e){
            logger.error("查询购物车列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改购物车购买数量
     * @param shoppingCart
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ShoppingCart shoppingCart){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCart.setUserId(userId);
            return shoppingCartService.updateShoppingCart(shoppingCart);
        }catch (Exception e){
            logger.error("修改购物车购买数量失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车
     * @param shopCartId
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shopCartId){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            return shoppingCartService.deleteShoppingCart(shopCartId, userId);
        } catch (Exception e){
            logger.error("删除购物车失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
