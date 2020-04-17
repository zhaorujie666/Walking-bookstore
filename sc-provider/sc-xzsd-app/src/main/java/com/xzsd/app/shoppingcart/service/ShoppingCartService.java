package com.xzsd.app.shoppingcart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.shoppingcart.dao.ShoppingCartDao;
import com.xzsd.app.shoppingcart.entity.ShoppingCart;
import com.xzsd.app.shoppingcart.entity.ShoppingCartVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Descruption 购物车业务逻辑层
 * @author zhaorujie
 * @date 2020/4/12
 */
@Service
public class ShoppingCartService {
    @Resource
    private ShoppingCartDao shoppingCartDao;

    /**
     * 新增购物车
     *
     * @param shoppingCart
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShoppingCart(ShoppingCart shoppingCart){
        //设置购物车id
        shoppingCart.setShopCartId(StringUtil.getCommonCode(2));
        int count = shoppingCartDao.addShoppingCart(shoppingCart);
        if(0 == count){
            return AppResponse.versionError("新增购物车失败");
        }
        return AppResponse.success("新增购物车成功");
    }

    /**
     * 查询购物车列表
     * @param shoppingCart
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    public AppResponse getListShoppingCart(ShoppingCart shoppingCart){
        //分页
        PageHelper.startPage(shoppingCart.getPageNum(), shoppingCart.getPageSize());
        List<ShoppingCartVO> listShoppingCart = shoppingCartDao.getListShoppingCart(shoppingCart);
        PageInfo<ShoppingCartVO> pageData = new PageInfo<>(listShoppingCart);
        return AppResponse.success("查询购物车列表成功", pageData);
    }

    /**
     * 修改购物车购买数量
     * @param shoppingCart
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCart(ShoppingCart shoppingCart){
        int count = shoppingCartDao.updateShoppingCart(shoppingCart);
        if(0 == count){
            return AppResponse.versionError("修改购物车购买数量失败");
        }
        return AppResponse.success("修改购物车购买数量成功");
    }

    /**
     * 删除购物车
     * @param shopCartId
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020/4/12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String shopCartId, String userId){
        //分割购物车id
        List<String> listShopCartId = Arrays.asList(shopCartId.split(","));
        int count = shoppingCartDao.deleteShoppingCart(listShopCartId, userId);
        if(0 == count){
            return AppResponse.versionError("删除购物车失败");
        }
        return AppResponse.success("删除购物车成功");
    }
}
