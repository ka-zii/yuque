package com.bkood.yuque.models.add;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.BookDetail;
import com.bkood.yuque.parameters.add.AddUsersReposParameters;

/**
 * 创建自己知识库
 * <a href="https://www.yuque.com/yuque/developer/repo#61eb4d2a">Doc</a>
 */
public class AddUsersRepos implements RequestParameters<AddUsersReposParameters, Result<BookDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/users/{0}/repos";



    /**
     * 请求基础构造
     * @param idOrLogin 用户id 或 login
     * @param config {@link Config} 配置
     */
    public AddUsersRepos(String idOrLogin, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrLogin), config);
    }

    @Override
    public Result<BookDetail> run() {
        return new Result<>(execute(HttpMethod.POST), BookDetail.class);
    }
}
