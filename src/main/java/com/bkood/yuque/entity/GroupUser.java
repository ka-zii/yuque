package com.bkood.yuque.entity;

import lombok.Data;

import java.util.Date;

/**
 * 团队成员信息
 * <a href="https://www.yuque.com/yuque/developer/groupuserserializer">GroupUserSerializer</a>
 */
@Data
public class GroupUser {

    /**
     * GroupUser ID
     */
    Long id;

    /**
     * 团队编号
     */
    Integer groupId;

    /**
     * 团队信息
     */
    User group;

    /**
     * 用户编号
     */
    Integer userId;

    /**
     * 角色
     * <li>0 - 管理员</li>
     * <li>1 - 成员</li>
     */
    Integer role;

    /**
     * 用户信息
     */
    User user;

    /**
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;
}
