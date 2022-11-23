package com.bkood.yuque.models.delete;

import cn.hutool.http.HttpRequest;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.Request;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.BookDetail;

/**
 * 删除知识库
 * <a href="https://www.yuque.com/yuque/developer/repo#fc1ba0e0">Doc</a>
 */
public class DeleteRepos implements Request<Result<BookDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}";

    /**
     * 请求类
     */
    private final HttpRequest request;

    /**
     * 请求基础构造
     * @param idOrNamespace
     * @param config {@link Config} 配置
     */
    public DeleteRepos(String idOrNamespace, Config config) {
        this.request = HttpRequest.delete(toUrl(config.getBaseUrl(), URL, idOrNamespace));
        setConfigToRequest(this.request, config);
    }

    @Override
    public Result<BookDetail> run() {
        return new Result<>(execute(this.request), BookDetail.class);
    }
}
