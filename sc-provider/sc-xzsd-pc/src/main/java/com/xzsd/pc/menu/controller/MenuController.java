package com.xzsd.pc.menu.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.entity.Menu;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @author zhaorujie
 * @date 2020-4-8
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;

    /**
     * 查询菜单列表
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @PostMapping("listMenu")
    public AppResponse getListMenu(){
        try {
            return menuService.getListMenu();
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(Menu menu){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menu.setCreateUser(userId);
            return menuService.addMenu(menu);
        }catch (Exception e){
            logger.error("新增菜单失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     *
     * @param menuId
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @PostMapping("getMenu")
    public AppResponse getMenuById(String menuId){
        try {
            return menuService.getMenuById(menuId);
        }catch (Exception e){
            logger.error("查新菜单详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单信息
     * @param menu
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(Menu menu){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menu.setUpdateUser(userId);
            return menuService.updateMenu(menu);
        }catch (Exception e){
            logger.error("修改菜单失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuId){
        try {
            String loginUserId = SecurityUtils.getCurrentUserId();
            return menuService.deleteMenu(menuId, loginUserId);
        }catch (Exception e){
            logger.error("删除菜单失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 根据角色查询菜单
     * @param role
     * @return
     * @author zhaorujie
     * @date 2020-4-15
     */
    @PostMapping("listMenuHome")
    public AppResponse getPageHomeMenu(String role){
        try {
            return menuService.getPageHomeMenu(role);
        }catch (Exception e){
            logger.error("根据角色查询菜单失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
