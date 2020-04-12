package com.xzsd.app.shoppingcart.dao;

import com.xzsd.app.shoppingcart.entity.ShoppingCart;
import com.xzsd.app.shoppingcart.entity.ShoppingCartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 购物车dao层
 * @author zhaorujie
 * @date 2020/4/12
 */
@Mapper
public interface ShoppingCartDao {
    /**
     * 新增购物车
     * @param shoppingCart
     * @return
     */
    int addShoppingCart(ShoppingCart shoppingCart);

    /**
     * 查询购物车列表
     * @param shoppingCart
     * @return
     */
    List<ShoppingCartVO> getListShoppingCart(ShoppingCart shoppingCart);

    /**
     * 修改购物车购买数量
     * @param shoppingCart
     * @return
     */
    int updateShoppingCart(ShoppingCart shoppingCart);

    /**
     * 删除购物车
     * @param listShopCartId
     * @param userId
     * @return
     */
    int deleteShoppingCart(@Param("listShopCartId") List<String> listShopCartId, @Param("userId") String userId);
}
