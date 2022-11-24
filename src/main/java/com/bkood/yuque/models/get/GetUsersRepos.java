package com.bkood.yuque.models.get;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.ResultList;
import com.bkood.yuque.entity.Book;
import com.bkood.yuque.parameters.query.QueryUsersReposParameters;

/**
 * 获取某个用户的知识库列表
 * <a href="https://www.yuque.com/yuque/developer/group">Doc</a>
 */
public class GetUsersRepos implements RequestParameters<QueryUsersReposParameters, ResultList<Book>> {

    /**
     * 请求路径
     */
    public static final String URL = "/users/{0}/repos";



    /**
     * 请求基础构造
     * @param idOrLogin id 或 login
     * @param config {@link Config} 配置
     */
    public GetUsersRepos(String idOrLogin, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrLogin), config);
    }

    @Override
    public ResultList<Book> run() {
        return new ResultList<>(execute(HttpMethod.GET), Book.class);
    }
}
