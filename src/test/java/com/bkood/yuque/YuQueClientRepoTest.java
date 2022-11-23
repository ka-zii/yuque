package com.bkood.yuque;

import com.bkood.yuque.common.Result;
import com.bkood.yuque.common.ResultList;
import com.bkood.yuque.entity.Book;
import com.bkood.yuque.entity.BookDetail;
import com.bkood.yuque.parameters.add.AddGroupsReposParameters;
import com.bkood.yuque.parameters.add.AddUsersReposParameters;
import com.bkood.yuque.parameters.query.QueryGroupsReposParameters;
import com.bkood.yuque.parameters.update.UpdateReposParameters;
import org.junit.Assert;
import org.junit.Test;

import static com.bkood.yuque.TestConfig.getConfig;

/**
 * Repo - 知识库
 */
public class YuQueClientRepoTest {

    /**
     * 通过用户ID 获取知识库详情
     */
    @Test
    public void testClientReposById() {
        Result<BookDetail> result = YuQueClient.query(getConfig()).repos(TestConfig.id).run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户Login 获取知识库详情
     */
    @Test
    public void testClientReposByLogin() {
        Result<BookDetail> result = YuQueClient.query(getConfig()).repos("xiaotian-hbdyc/kb").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户ID 获取某个用户知识库列表
     */
    @Test
    public void testClientUsersReposById() {
        ResultList<Book> result = YuQueClient.query(getConfig()).usersRepos(TestConfig.login).run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户Login 获取某个用户知识库列表
     */
    @Test
    public void testClientUsersReposByLogin() {
        ResultList<Book> result = YuQueClient.query(getConfig()).usersRepos(TestConfig.login).run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户ID 获取团队知识库列表
     */
    @Test
    public void testClientGroupsReposById() {
        ResultList<Book> result = YuQueClient.query(getConfig()).groupsRepos(TestConfig.login)
                .parameter(QueryGroupsReposParameters::getType, "Design")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户Login 获取团队知识库列表
     */
    @Test
    public void testClientGroupsReposByLogin() {
        ResultList<Book> result = YuQueClient.query(getConfig()).groupsRepos(TestConfig.login)
                //.parameter(QueryGroupsReposParameters::getType, "Design")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户ID 创建队创建知识库
     */
    @Test
    public void testClientAddGroupsReposById() {
        Result<BookDetail> result = YuQueClient.add(getConfig()).groupsRepos(TestConfig.login)
                .parameter(AddGroupsReposParameters::getType, "Book")
                .parameter(AddGroupsReposParameters::getPublic, 0)
                .parameter(AddGroupsReposParameters::getDescription, "说明")
                .parameter(AddGroupsReposParameters::getSlug, "slug")
                .parameter(AddGroupsReposParameters::getName, "仓库名称")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户Login 创建队创建知识库
     */
    @Test
    public void testClientAddGroupsReposByLogin() {
        Result<BookDetail> result = YuQueClient.add(getConfig()).groupsRepos(TestConfig.login)
                .parameter(AddGroupsReposParameters::getType, "Book")
                .parameter(AddGroupsReposParameters::getPublic, 0)
                .parameter(AddGroupsReposParameters::getDescription, "说明")
                .parameter(AddGroupsReposParameters::getSlug, "slug2")
                .parameter(AddGroupsReposParameters::getName, "仓库名称-2")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户ID 创建自己知识库
     */
    @Test
    public void testClientAddUsersReposById() {
        Result<BookDetail> result = YuQueClient.add(getConfig()).usersRepos(TestConfig.login)
                .parameter(AddUsersReposParameters::getType, "Book")
                .parameter(AddUsersReposParameters::getPublic, 0)
                .parameter(AddUsersReposParameters::getDescription, "说明")
                .parameter(AddUsersReposParameters::getSlug, "user-slug")
                .parameter(AddUsersReposParameters::getName, "仓库名称")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户Login 创建自己知识库
     */
    @Test
    public void testClientAddUsersReposByLogin() {
        Result<BookDetail> result = YuQueClient.add(getConfig()).usersRepos(TestConfig.login)
                .parameter(AddUsersReposParameters::getType, "Book")
                .parameter(AddUsersReposParameters::getPublic, 0)
                .parameter(AddUsersReposParameters::getDescription, "说明")
                .parameter(AddUsersReposParameters::getSlug, "user-slug-2")
                .parameter(AddUsersReposParameters::getName, "仓库名称22")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过知识库ID 更新自己知识库
     */
    @Test
    public void testClientUpdateReposById() {
        Result<BookDetail> result = YuQueClient.update(getConfig()).repos("35145380")
                .parameter(UpdateReposParameters::getPublic, 0)
                .parameter(UpdateReposParameters::getDescription, "说明")
                .parameter(UpdateReposParameters::getSlug, "user-slug-up-by-id")
                .parameter(UpdateReposParameters::getName, "仓库名称-up-by-id")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过知识库Login 更新自己知识库
     */
    @Test
    public void testClientUpdateReposByLogin() {
        Result<BookDetail> result = YuQueClient.update(getConfig()).repos("xiaotian-hbdyc/user-slug-up-by-id")
                .parameter(UpdateReposParameters::getPublic, 0)
                .parameter(UpdateReposParameters::getDescription, "说明")
                .parameter(UpdateReposParameters::getSlug, "user-slug-up-by-login")
                .parameter(UpdateReposParameters::getName, "仓库名称-up-by-login")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过知识库Namespace 删除知识库
     */
    @Test
    public void testClientDeleteReposByNamespace() {
        Result<BookDetail> result = YuQueClient.delete(getConfig()).repos("xiaotian-hbdyc/user-slug-up-by-login").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过知识库Id 删除知识库
     */
    @Test
    public void testClientDeleteReposById() {
        Result<BookDetail> result = YuQueClient.delete(getConfig()).repos("35143462").run();
        Assert.assertEquals(200, result.getStatus());
    }


}