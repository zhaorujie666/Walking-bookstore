package com.xzsd.app.customerime.entity;

/**
 * @Description 客户端邀请码修改
 * @author zhaorujie
 * @date 2020/4/14
 */
public class CustomerMe {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 邀请码
     */
    private String inviteCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
