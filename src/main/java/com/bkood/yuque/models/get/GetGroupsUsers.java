package com.bkood.yuque.models.get;

import cn.hutool.http.HttpRequest;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.ResultList;
import com.bkood.yuque.entity.GroupUser;
import com.bkood.yuque.parameters.query.QueryGroupsUsersParameters;

/**
 * 获取组织成员信息
 * <a href="https://www.yuque.com/yuque/developer/group#qf4xae">Doc</a>
 */
public class GetGroupsUsers implements RequestParameters<QueryGroupsUsersParameters, ResultList<GroupUser>> {

    /**
     * 请求路径
     */
    public static final String URL = "/groups/{0}/users";

    /**
     * 请求类
     */
    private final HttpRequest request;

    /**
     * 请求基础构造
     * @param groupIdOrLogin 组织 id 或 login
     * @param config {@link Config} 配置
     */
    public GetGroupsUsers(String groupIdOrLogin, Config config) {
        this.request = HttpRequest.get(toUrl(config.getBaseUrl(), URL, groupIdOrLogin));
        setConfigToRequest(this.request, config);
    }

    @Override
    public ResultList<GroupUser> run() {
        return new ResultList<>(execute(this.request), GroupUser.class);
    }
}
