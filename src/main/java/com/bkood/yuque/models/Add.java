package com.bkood.yuque.models;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.models.add.AddGroupsRepos;
import com.bkood.yuque.models.add.AddReposDoc;
import com.bkood.yuque.models.add.AddUsersRepos;

/**
 * 实现语雀新增接口调用
 */
public class Add {

    /**
     * 配置
     */
    private final Config config;

    public Add(Config config) {
        this.config = config;
    }

    /**
     * 创建团队知识库
     *
     * @param idOrLogin 用户ID 或 login
     * @return {@link AddUsersRepos}
     */
    public AddGroupsRepos groupsRepos(String idOrLogin) {
        return new AddGroupsRepos(idOrLogin, this.config);
    }

    /**
     * 创建文档
     *
     * @param idOrNamespace 用户ID 或 namespace（仓库的唯一名称）
     * @return {@link AddReposDoc}
     */
    public AddReposDoc reposDoc(String idOrNamespace) {
        return new AddReposDoc(idOrNamespace, this.config);
    }

    /**
     * 创建自己知识库
     *
     * @param idOrLogin 用户ID 或 login
     * @return {@link AddUsersRepos}
     */
    public AddUsersRepos usersRepos(String idOrLogin) {
        return new AddUsersRepos(idOrLogin, this.config);
    }

}
