package com.bkood.yuque.models.add;

import cn.hutool.http.HttpRequest;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.BookDetail;
import com.bkood.yuque.parameters.add.AddGroupsReposParameters;

/**
 * 创建团队知识库
 * <a href="https://www.yuque.com/yuque/developer/repo#61eb4d2a">Doc</a>
 */
public class AddGroupsRepos implements RequestParameters<AddGroupsReposParameters, Result<BookDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/users/{0}/repos";

    /**
     * 请求类
     */
    private final HttpRequest request;

    /**
     * 请求基础构造
     * @param idOrLogin 用户ID 或 login
     * @param config {@link Config} 配置
     */
    public AddGroupsRepos(String idOrLogin, Config config) {
        this.request = HttpRequest.post(toUrl(config.getBaseUrl(), URL, idOrLogin));
        setConfigToRequest(this.request, config);
    }

    @Override
    public Result<BookDetail> run() {
        return new Result<>(execute(this.request), BookDetail.class);
    }
}
