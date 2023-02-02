package com.bkood.yuque.models.update;

import com.bkood.yuque.common.AbstractRequestParametersData;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.GroupUser;
import com.bkood.yuque.parameters.update.UpdateGroupsUsersParameters;

/**
 * 增加或更新组织成员
 * <a href="https://www.yuque.com/yuque/developer/group#am7zgu">Doc</a>
 */
public class UpdateGroupsUsers extends AbstractRequestParametersData<UpdateGroupsUsersParameters, Result<GroupUser>> {

    /**
     * 请求路径
     */
    public static final String URL = "/groups/{0}/users/{1}";



    /**
     * 请求基础构造
     * @param groupLoginOrId 组织login或id
     * @param login 新增用户的login
     * @param config {@link Config} 配置
     */
    public UpdateGroupsUsers(String groupLoginOrId, String login, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, groupLoginOrId, login), config);
    }

    @Override
    public Result<GroupUser> run() {
        return new Result<>(execute(HttpMethod.PUT), GroupUser.class);
    }
}
