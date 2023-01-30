package com.bkood.yuque.models.delete;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Request;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.BookDetail;

/**
 * 删除知识库
 * <a href="https://www.yuque.com/yuque/developer/repo#fc1ba0e0">Doc</a>
 */
public class DeleteRepos extends Request<Result<BookDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}";



    /**
     * 请求基础构造
     * @param idOrNamespace 用户ID 或 namespace（仓库的唯一名称）
     * @param config {@link Config} 配置
     */
    public DeleteRepos(String idOrNamespace, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrNamespace), config);
    }

    @Override
    public Result<BookDetail> run() {
        return new Result<>(execute(HttpMethod.DELETE), BookDetail.class);
    }
}
