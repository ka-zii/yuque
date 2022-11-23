package com.bkood.yuque.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户/团队详细信息
 * <a href="https://www.yuque.com/yuque/developer/userdetailserializer">UserDetailSerializer</a>
 */
@Data
public class UserDetail {

    /**
     * 用户资料编号
     */
    Long id;

    /**
     * 企业空间编号
     */
    Long spaceId;

    /**
     * 用户账户编号
     */
    Long spacaccountId;

    /**
     * 类型
     * <li>User - 用户</li>
     * <li>Group - 团队</li>
     */
    String type;

    /**
     * 用户个人路径
     */
    String login;

    /**
     * 昵称
     */
    String name;

    /**
     * 团队创建人，仅适用于 type - 'Group'
     */
    Long ownerId;

    /**
     * 头像 URL
     */
    String avatarUrl;

    /**
     * 仓库数量
     */
    Integer booksCount;

    /**
     * 公开仓库数量
     */
    Integer publicBooksCount;

    /**
     * 团队成员数量
     */
    Integer membersCount;

    /**
     * 介绍
     */
    String description;


    /**
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;

}
