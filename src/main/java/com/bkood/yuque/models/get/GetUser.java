package com.bkood.yuque.models.get;

import cn.hutool.http.HttpRequest;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.Request;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.User;

/**
 * 获取单个用户信息
 * <a href="https://www.yuque.com/yuque/developer/user#7cf55244">Doc</a>
 */
public class GetUser implements Request<Result<User>> {

    /**
     * 请求路径
     */
    public static final String URL = "/user";

    /**
     * 请求类
     */
    private final HttpRequest request;

    /**
     * 请求基础构造
     * @param config {@link Config} 配置
     */
    public GetUser(Config config) {
        this.request = HttpRequest.get(config.getBaseUrl() + URL);
        setConfigToRequest(this.request, config);
    }

    @Override
    public Result<User> run() {
        return new Result<>(execute(this.request), User.class);
    }
}
