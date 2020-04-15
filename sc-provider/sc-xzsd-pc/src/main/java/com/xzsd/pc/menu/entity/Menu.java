package com.xzsd.pc.menu.entity;

/**
 * @Description 菜单实体类
 * @author zhaorujie
 * @date 2020/4/9
 */
public class Menu {
    /**
     * 菜单id
     */
    private String menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单路由
     */
    private String menuPath;
    /**
     * 是否菜单（默认是菜单，不能修改）
     */
    private String isMenu;
    /**
     * 角色编号
     */
    private String role;
    /**
     * 删除标记（0存在，1删除）
     */
    private String isDelete;
    /**
     * 备注
     */
    private String menuComment;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private String  createTime;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 版本
     */
    private String version;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getMenuComment() {
        return menuComment;
    }

    public void setMenuComment(String menuComment) {
        this.menuComment = menuComment;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
