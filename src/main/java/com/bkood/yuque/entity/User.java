package com.bkood.yuque.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * <a href="https://www.yuque.com/yuque/developer/userserializer">UserSerializer</a>
 */
@Data
public class User {

    /**
     * 用户编号
     */
    Long id;

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
     * 头像 URL
     */
    String avatarUrl;

    /**
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;

}
