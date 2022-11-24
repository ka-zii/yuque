package com.bkood.yuque;

import com.bkood.yuque.common.Result;
import com.bkood.yuque.common.ResultList;
import com.bkood.yuque.entity.Doc;
import com.bkood.yuque.entity.DocDetail;
import com.bkood.yuque.parameters.add.AddReposDocParameters;
import com.bkood.yuque.parameters.query.QueryReposDocParameters;
import com.bkood.yuque.parameters.query.QueryReposDocsParameters;
import com.bkood.yuque.parameters.update.UpdateReposDocParameters;
import org.junit.Assert;
import org.junit.Test;

import static com.bkood.yuque.TestConfig.getConfig;

/**
 * Doc - 文档
 */
public class YuQueClientDocTest {

    /**
     * 通过仓库的唯一名称和文档路径 获取 获取单篇文档的详细信息
     */
    @Test
    public void testClientReposDoc() {
        Result<DocDetail> result = YuQueClient.query(getConfig()).reposDoc("xiaotian-hbdyc/kb", "mir4uzerslm7n3n3")
                .parameter(QueryReposDocParameters::getRaw, 1)
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过仓库文章ID 获取一个仓库的文档列表
     */
    @Test
    public void testClientReposDocsById() {
        ResultList<Doc> result = YuQueClient.query(getConfig()).reposDocs("413641")
                .parameter(QueryReposDocsParameters::getOptionalProperties, "Design")
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过仓库的唯一名称 获取一个仓库的文档列表
     */
    @Test
    public void testClientReposDocsByNamespace() {
        ResultList<Doc> result = YuQueClient.query(getConfig()).reposDocs("xiaotian-hbdyc/kb").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过仓库的唯一名称 创建文档
     */
    @Test
    public void testClientAddReposDocByNamespace() {
        Result<DocDetail> result = YuQueClient.add(getConfig()).reposDoc("xiaotian-hbdyc/kb")
                .parameter(AddReposDocParameters::getTitle,"标题")
                .parameter(AddReposDocParameters::getSlug,"test-slug")
                .parameter(AddReposDocParameters::getBody,"html")
                .parameter(AddReposDocParameters::getBody,"test").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户ID 创建文档
     */
    @Test
    public void testClientAddReposDocById() {
        Result<DocDetail> result = YuQueClient.add(getConfig()).reposDoc("413641")
                .parameter(AddReposDocParameters::getTitle,"标题")
                .parameter(AddReposDocParameters::getSlug,"test-slug-2")
                .parameter(AddReposDocParameters::getBody,"html")
                .parameter(AddReposDocParameters::getBody,"test").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过仓库的唯一名称 更新文档
     */
    @Test
    public void testClientUpdateReposDoc() {
        Result<DocDetail> result = YuQueClient.update(getConfig()).reposDocs("xiaotian-hbdyc/kb", "107268854")
                .parameter(UpdateReposDocParameters::getTitle,"标题-Update")
                .parameter(UpdateReposDocParameters::getSlug,"test-slug-update")
                .parameter(UpdateReposDocParameters::getBody,"html")
                .parameter(UpdateReposDocParameters::getBody,"testUpdate").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 删除文档
     */
    @Test
    public void testClientReposByNamespace() {
        Result<DocDetail> result = YuQueClient.delete(getConfig()).reposDocs("xiaotian-hbdyc/kb","106567384").run();
        Assert.assertEquals(200, result.getStatus());
    }
}