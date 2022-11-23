package com.bkood.yuque.models;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.models.update.UpdateGroupsUsers;
import com.bkood.yuque.models.update.UpdateRepos;
import com.bkood.yuque.models.update.UpdateReposDocs;

/**
 * 实现语雀更新接口调用
 */
public class Update {

    /**
     * 配置
     */
    private final Config config;

    public Update(Config config) {
        this.config = config;
    }

    /**
     * 更新知识库信息
     *
     * @param idOrNamespace  知识库的 id 或 namespace（仓库的唯一名称）
     * @return {@link  UpdateRepos}
     */
    public UpdateRepos repos(String idOrNamespace) {
        return new UpdateRepos(idOrNamespace, this.config);
    }

    /**
     * 更新文档
     * @param repoIdOrNamespace 仓库编号(bookId仓库编号，就是 repoId) 或 namespace（仓库的唯一名称）
     * @param id 文档编号 ID
     * @return {@link UpdateReposDocs}
     */
    public UpdateReposDocs reposDocs(String repoIdOrNamespace, String id) {
        return new UpdateReposDocs(repoIdOrNamespace, id, this.config);
    }

    /**
     * 增加或更新组织成员
     *
     * @param groupLoginOrId 组织 Login 或 Id
     * @param login 用户 Login
     * @return {@link UpdateGroupsUsers}
     */
    public UpdateGroupsUsers groupsUsers(String groupLoginOrId, String login) {
        return new UpdateGroupsUsers(groupLoginOrId, login, this.config);
    }
}
