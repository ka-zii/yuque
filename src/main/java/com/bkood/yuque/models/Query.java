package com.bkood.yuque.models;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.models.get.*;

/**
 * 实现语雀查询接口调用
 */
public class Query {

    /**
     * 配置
     */
    private final Config config;

    public Query(Config config) {
        this.config = config;
    }

    /**
     * 获取单个用户信息
     *
     * @param idOrLogin 用户ID 或 login
     * @return {@link GetUsers}
     */
    public GetUsers users(String idOrLogin) {
        return new GetUsers(idOrLogin, this.config);
    }

    /**
     * 获取单个用户信息
     *
     * @return {@link GetUser}
     */
    public GetUser user() {
        return new GetUser(this.config);
    }

    /**
     * 获取某个用户的加入的组织列表
     *
     * @param idOrLogin 用户ID 或 login
     * @return {@link GetUsersGroup}
     */
    public GetUsersGroup usersGroup(String idOrLogin) {
        return new GetUsersGroup(idOrLogin, this.config);
    }

    /**
     * 获取组织成员信息
     *
     * @param groupIdOrLogin 组织 id 或 login
     * @return {@link GetGroupsUsers}
     */
    public GetGroupsUsers groupsUsers(String groupIdOrLogin) {
        return new GetGroupsUsers(groupIdOrLogin, this.config);
    }

    /**
     * 获取某个用户的知识库列表
     *
     * @param idOrLogin 用户ID 或 login
     * @return {@link GetUsersRepos}
     */
    public GetUsersRepos usersRepos(String idOrLogin) {
        return new GetUsersRepos(idOrLogin, this.config);
    }

    /**
     * 获取团队的知识库列表
     *
     * @param idOrLogin 用户ID 或 login
     * @return {@link GetGroupsRepos}
     */
    public GetGroupsRepos groupsRepos(String idOrLogin) {
        return new GetGroupsRepos(idOrLogin, this.config);
    }

    /**
     * 获取知识库详情
     *
     * @param idOrNamespace 用户ID 或 namespace（仓库的唯一名称）
     * @return {@link GetRepos}
     */
    public GetRepos repos(String idOrNamespace) {
        return new GetRepos(idOrNamespace, this.config);
    }


    /**
     * 获取一个仓库的文档列表
     *
     * @param idOrNamespace 用户ID 或 namespace（仓库的唯一名称）
     * @return {@link GetReposDocs}
     */
    public GetReposDocs reposDocs(String idOrNamespace) {
        return new GetReposDocs(idOrNamespace, this.config);
    }

    /**
     * 获取单篇文档的详细信息
     *
     * @param namespace namespace（仓库的唯一名称）
     * @param slug  文档路径
     * @return {@link GetReposDoc}
     */
    public GetReposDoc reposDoc(String namespace, String slug) {
        return new GetReposDoc(namespace, slug, this.config);
    }


}
