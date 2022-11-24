package com.bkood.yuque.models.update;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.BookDetail;
import com.bkood.yuque.parameters.update.UpdateReposParameters;

/**
 * 更新知识库信息 <a href="https://www.yuque.com/yuque/developer/repo#2ba1bac6">Doc</a><br/>
 * 需要 Repo 的 abilities.update 权限
 */
public class UpdateRepos implements RequestParameters<UpdateReposParameters, Result<BookDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}";



    /**
     * 请求基础构造
     * @param idOrNamespace 知识库的 id 或 namespace（仓库的唯一名称）
     * @param config {@link Config} 配置
     */
    public UpdateRepos(String idOrNamespace, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrNamespace), config);
    }

    @Override
    public Result<BookDetail> run() {
        return new Result<>(execute(HttpMethod.PUT), BookDetail.class);
    }
}
