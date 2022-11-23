package com.bkood.yuque.parameters.update;

import lombok.Data;

/**
 * 增加或更新组织成员
 * <a href="https://www.yuque.com/yuque/developer/group#wp8lgg">Parameters</a>
 */
@Data
public class UpdateGroupsUsersParameters {

    /**
     * 角色
     * <li>0 - 管理员</li>
     * <li>1 - 普通成员</li>
     */
    Integer role;

}
