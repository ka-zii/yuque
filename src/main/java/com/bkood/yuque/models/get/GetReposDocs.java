package com.bkood.yuque.models.get;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.ResultList;
import com.bkood.yuque.entity.Doc;
import com.bkood.yuque.parameters.query.QueryReposDocsParameters;

/**
 * 获取一个仓库的文档列表
 * <a href="https://www.yuque.com/yuque/developer/doc#6d560c5e">Doc</a>
 */
public class GetReposDocs implements RequestParameters<QueryReposDocsParameters, ResultList<Doc>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}/docs";



    /**
     * 请求基础构造
     * @param idOrNamespace  用户ID 或 namespace（仓库的唯一名称）
     * @param config {@link Config} 配置
     */
    public GetReposDocs(String idOrNamespace, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrNamespace), config);
    }

    @Override
    public ResultList<Doc> run() {
        return new ResultList<>(execute(HttpMethod.GET), Doc.class);
    }
}
