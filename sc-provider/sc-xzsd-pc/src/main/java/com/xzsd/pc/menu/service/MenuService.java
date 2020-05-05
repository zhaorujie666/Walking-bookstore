package com.xzsd.pc.menu.service;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuList;
import com.xzsd.pc.menu.entity.Menu;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName MenuService
 * @Description 菜单管理，增删改查
 * @author zhaorujie
 * @date 2020-4-8
 */
@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 查询菜单列表
     *
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    public AppResponse getListMenu(){
        List<Menu> listMenuVO = menuDao.getListMenu();
        //封装成接口文档对应的list名称
        MenuList menuList = new MenuList();
        menuList.setMenuList(listMenuVO);
        return AppResponse.success("查询菜单列表成功！", menuList);
    }

    /**
     * 新增菜单
     * @param menu
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(Menu menu){
        int count = menuDao.countMenuNameAndMenuPath(menu);
        if(count == 1){
            return AppResponse.versionError("存在相同的菜单名，请重新输入");
        }
        if(count == 2){
            return AppResponse.versionError("存在相同的菜单路由，请重新输入");
        }
        if(count == 3){
            return AppResponse.versionError("存在相同的菜单名和菜单路由，请重新输入");
        }
        //设置菜单id
        menu.setMenuId(StringUtil.getCommonCode(2));
        int addMenu = menuDao.addMenu(menu);
        if(0 == addMenu){
            return AppResponse.versionError("新增菜单失败！");
        }
        return AppResponse.success("新增菜单成功！");
    }

    /**
     * 查询用户详情
     * @param menuId
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    public AppResponse getMenuById(String menuId){
        Menu menu = menuDao.getMenuById(menuId);
        if(menu == null){
            return AppResponse.versionError("查询用户详情失败");
        }
        return AppResponse.success("查询用户详情成功！", menu);
    }

    /**
     * 修改菜单信息
     *
     * @param menu
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(Menu menu){
        //判断是否存在相同的菜单名和菜单路由
        int count = menuDao.countMenuNameAndMenuPath(menu);
        if(count == 1){
            return AppResponse.versionError("存在相同的菜单名，请重新输入");
        }
        if(count == 2){
            return AppResponse.versionError("存在相同的菜单路由，请重新输入");
        }
        if(count == 3){
            return AppResponse.versionError("存在相同的菜单名和菜单路由，请重新输入");
        }
        int updateMenu = menuDao.updateMenu(menu);
        if(0 == updateMenu){
            return AppResponse.versionError("修改菜单失败");
        }
        return AppResponse.success("修改菜单成功");
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @param loginUserId
     * @return
     * @author zhaorujie
     * @date 2020-4-8
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuId, String loginUserId){
        int deleteMenu = menuDao.deleteMenu(menuId, loginUserId);
        if(0 == deleteMenu){
            return AppResponse.versionError("删除菜单失败！");
        }
        return AppResponse.success("删除菜单成功");
    }

    /**
     * 根据角色查询菜单
     * @param role
     * @return
     * @author zhaorujie
     * @date 2020-4-15
     */
    public AppResponse getPageHomeMenu(String role){
        List<Menu> pageHomeMenu = menuDao.getPageHomeMenu(role);
        //封装数据
        MenuList menuList = new MenuList();
        menuList.setMenuList(pageHomeMenu);
        return AppResponse.success("根据角色查询菜单成功", menuList);
    }
}
