package com.bkood.yuque.models.get;

import com.bkood.yuque.common.AbstractRequestParametersData;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.BookDetail;
import com.bkood.yuque.parameters.query.QueryReposParameters;

/**
 * 获取知识库详情
 * <a href="https://www.yuque.com/yuque/developer/repo#4a6c3a3b">Doc</a>
 */
public class GetRepos extends AbstractRequestParametersData<QueryReposParameters, Result<BookDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}";



    /**
     * 请求基础构造
     * @param idOrNamespace 用户ID 或 namespace（仓库的唯一名称）
     * @param config {@link Config} 配置
     */
    public GetRepos(String idOrNamespace, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrNamespace), config);
    }

    @Override
    public Result<BookDetail> run() {
        return new Result<>(execute(HttpMethod.GET), BookDetail.class);
    }
}
