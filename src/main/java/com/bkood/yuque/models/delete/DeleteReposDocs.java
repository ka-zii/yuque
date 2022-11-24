package com.bkood.yuque.models.delete;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Request;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.DocDetail;

/**
 * 删除文档 <a href="https://www.yuque.com/yuque/developer/doc#f28f9fb9">Doc</a><br/>
 * 需要 Doc 的 abilities.destroy 权限
 */
public class DeleteReposDocs implements Request<Result<DocDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}/docs/{1}";



    /**
     * 请求基础构造
     * @param repoIdOrNamespace 仓库编号(bookId仓库编号，就是 repoId) 或 namespace（仓库的唯一名称）
     * @param id 文档编号 ID
     * @param config {@link Config} 配置
     */
    public DeleteReposDocs(String repoIdOrNamespace, String id, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, repoIdOrNamespace, id), config);
    }

    @Override
    public Result<DocDetail> run() {
        return new Result<>(execute(HttpMethod.DELETE), DocDetail.class);
    }
}
