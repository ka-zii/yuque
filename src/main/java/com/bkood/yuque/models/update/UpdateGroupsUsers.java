package com.bkood.yuque.models.update;

import cn.hutool.http.HttpRequest;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.RequestParameters;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.GroupUser;
import com.bkood.yuque.parameters.update.UpdateGroupsUsersParameters;

/**
 * 增加或更新组织成员
 * <a href="https://www.yuque.com/yuque/developer/group#am7zgu">Doc</a>
 */
public class UpdateGroupsUsers implements RequestParameters<UpdateGroupsUsersParameters, Result<GroupUser>> {

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
     * @param login 新增用户的login
     * @param config {@link Config} 配置
     */
    public UpdateGroupsUsers(String groupLoginOrId, String login, Config config) {
        this.request = HttpRequest.put(toUrl(config.getBaseUrl(), URL, groupLoginOrId, login));
        setConfigToRequest(this.request, config);
    }

    @Override
    public Result<GroupUser> run() {
        return new Result<>(execute(this.request), GroupUser.class);
    }
}
