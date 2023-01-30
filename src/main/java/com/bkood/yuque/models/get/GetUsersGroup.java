package com.bkood.yuque.models.get;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Request;
import com.bkood.yuque.common.ResultList;
import com.bkood.yuque.entity.User;

/**
 * 获取某个用户的加入的组织列表
 * <a href="https://www.yuque.com/yuque/developer/group#13hlny">Doc</a>
 */
public class GetUsersGroup extends Request<ResultList<User>> {

    /**
     * 请求路径
     */
    public static final String URL = "/users/{0}/groups";



    /**
     * 请求基础构造
     * @param idOrLogin id 或 login
     * @param config {@link Config} 配置
     */
    public GetUsersGroup(String idOrLogin, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrLogin), config);
    }

    @Override
    public ResultList<User> run() {
        return new ResultList<>(execute(HttpMethod.GET), User.class);
    }
}
