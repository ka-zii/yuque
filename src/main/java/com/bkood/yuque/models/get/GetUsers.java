package com.bkood.yuque.models.get;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Request;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.User;

/**
 * 获取单个用户信息
 * <a href="https://www.yuque.com/yuque/developer/user#8910bb47">Doc</a>
 */
public class GetUsers extends Request<Result<User>> {

    /**
     * 请求路径
     */
    public static final String URL = "/users/{0}";




    /**
     * 请求基础构造
     * @param idOrLogin id 或 login
     * @param config    {@link Config} 配置
     */
    public GetUsers(String idOrLogin, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrLogin), config);
    }

    @Override
    public Result<User> run() {
        return new Result<>(execute(HttpMethod.GET), User.class);
    }
}
