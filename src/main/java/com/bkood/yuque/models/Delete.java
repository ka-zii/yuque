package com.bkood.yuque.models;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.models.delete.DeleteGroupsUsers;
import com.bkood.yuque.models.delete.DeleteRepos;
import com.bkood.yuque.models.delete.DeleteReposDocs;

/**
 * 实现语雀删除接口调用
 */
public class Delete {

    /**
     * 配置
     */
    private final Config config;

    public Delete(Config config) {
        this.config = config;
    }

    /**
     * 删除组织成员
     *
     * @param groupLoginOrId 组织login或id
     * @param login 删除用户的login
     * @return {@link DeleteGroupsUsers}
     */
    public DeleteGroupsUsers groupsUsers(String groupLoginOrId, String login) {
        return new DeleteGroupsUsers(groupLoginOrId, login, this.config);
    }

    /**
     * 删除知识库
     *
     * @param idOrNamespace 知识库 id 或 namespace（仓库的唯一名称）
     * @return {@link DeleteRepos}
     */
    public DeleteRepos repos(String idOrNamespace) {
        return new DeleteRepos(idOrNamespace, this.config);
    }

    /**
     * 删除文档
     * @param repoIdOrNamespace 仓库编号(bookId仓库编号，就是 repoId) 或 namespace（仓库的唯一名称）
     * @param id 文档编号 ID
     * @return {@link DeleteReposDocs}
     */
    public DeleteReposDocs reposDocs(String repoIdOrNamespace, String id) {
        return new DeleteReposDocs(repoIdOrNamespace, id, this.config);
    }

}
