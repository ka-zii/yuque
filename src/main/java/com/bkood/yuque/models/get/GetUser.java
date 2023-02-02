package com.bkood.yuque.models.get;

import com.bkood.yuque.common.AbstractRequestData;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.User;

/**
 * 获取单个用户信息
 * <a href="https://www.yuque.com/yuque/developer/user#7cf55244">Doc</a>
 */
public class GetUser extends AbstractRequestData<Result<User>> {

    /**
     * 请求路径
     */
    public static final String URL = "/user";



    /**
     * 请求基础构造
     * @param config {@link Config} 配置
     */
    public GetUser(Config config) {
        setConfigToRequest(config.getBaseUrl() + URL, config);
    }

    @Override
    public Result<User> run() {
        return new Result<>(execute(HttpMethod.GET), User.class);
    }
}
