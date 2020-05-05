package com.xzsd.pc.menu.dao;


import com.xzsd.pc.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description 菜单管理Dao层
 * @author zhaorujie
 * @date 2020-4-8
 */
@Mapper
public interface MenuDao {
    /**
     * 查询全部菜单
     *
     * @return
     */
    List<Menu> getListMenu();

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    int addMenu(Menu menu);

    /**
     * 统计是否存在相同的菜单名或菜单路由
     * @param menu
     * @return
     */
    int countMenuNameAndMenuPath(Menu menu);

    /**
     * 查询菜单详情
     * @param menuId
     * @return
     */
    Menu getMenuById(@Param("menuId") String menuId);

    /**
     * 更新菜单信息
     * @param menu
     * @return
     */
    int updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param menuId
     * @param loginUserId
     * @return
     */
    int deleteMenu(@Param("menuId") String menuId, @Param("loginUserId") String loginUserId);

    /**
     * 根据角色查询首页菜单显示的功能
     * @param role
     * @return
     */
    List<Menu> getPageHomeMenu(@Param("role") String role);
}
