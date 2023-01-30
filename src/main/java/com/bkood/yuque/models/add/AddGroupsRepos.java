package com.bkood.yuque.models.add;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.BookDetail;
import com.bkood.yuque.parameters.add.AddGroupsReposParameters;

/**
 * 创建团队知识库
 * <a href="https://www.yuque.com/yuque/developer/repo#61eb4d2a">Doc</a>
 */
public class AddGroupsRepos extends RequestParameters<AddGroupsReposParameters, Result<BookDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/users/{0}/repos";


    /**
     * 请求基础构造
     * @param idOrLogin 用户ID 或 login
     * @param config {@link Config} 配置
     */
    public AddGroupsRepos(String idOrLogin, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrLogin), config);
    }

    @Override
    public Result<BookDetail> run() {
        return new Result<>(execute(HttpMethod.POST), BookDetail.class);
    }
}
