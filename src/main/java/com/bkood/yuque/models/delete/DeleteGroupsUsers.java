package com.bkood.yuque.models.delete;

import cn.hutool.http.HttpRequest;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.Request;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.GroupUser;

/**
 * 删除组织成员
 * <a href="https://www.yuque.com/yuque/developer/group#e90bdm">Doc</a>
 */
public class DeleteGroupsUsers implements Request<Result<GroupUser>> {

    /**
     * 请求路径
     */
    public static final String URL = "/groups/{0}/users/{1}";

    /**
     * 请求类
     */
    private final HttpRequest request;

    /**
     * 请求基础构造
     * @param groupLoginOrId 组织login或id
     * @param login 删除用户的login
     * @param config {@link Config} 配置
     */
    public DeleteGroupsUsers(String groupLoginOrId, String login, Config config) {
        this.request = HttpRequest.delete(toUrl(config.getBaseUrl(), URL, groupLoginOrId, login));
        setConfigToRequest(this.request, config);
    }

    @Override
    public Result<GroupUser> run() {
        return new Result<>(execute(this.request), GroupUser.class);
    }
}
