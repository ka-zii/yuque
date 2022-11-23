package com.bkood.yuque.parameters.query;

import lombok.Data;

/**
 * 获取组织成员信息
 * <a href="https://www.yuque.com/yuque/developer/group#eHJ2I">Parameters</a>
 */
@Data
public class QueryGroupsUsersParameters {

    /**
     * <ul>0 - 管理员</ul>
     * <ul>1 - 成员</ul>
     */
    Integer role;

    /**
     * 从第几条开始取数据
     */
    Integer offset;

    /**
     * 取几条数据
     * max: 500
     */
    Integer limit;

}
