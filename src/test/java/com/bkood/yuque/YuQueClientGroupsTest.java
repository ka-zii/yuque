package com.bkood.yuque;

import com.bkood.yuque.common.Result;
import com.bkood.yuque.common.ResultList;
import com.bkood.yuque.entity.GroupUser;
import com.bkood.yuque.entity.User;
import com.bkood.yuque.parameters.query.QueryGroupsUsersParameters;
import org.junit.Assert;
import org.junit.Test;

import static com.bkood.yuque.TestConfig.getConfig;

/**
 * Group - 组织
 */
public class YuQueClientGroupsTest {

    /**
     * 通过组织Id 获取组织成员信息
     */
    @Test
    public void testClientGroupsUsersById() {
        ResultList<GroupUser> result = YuQueClient.query(getConfig()).groupsUsers("140148").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过组织Login 获取组织成员信息
     */
    @Test
    public void testClientGroupsUsersByLogin() {
        ResultList<GroupUser> result = YuQueClient.query(getConfig()).groupsUsers("afx-ued2")
                .parameter(QueryGroupsUsersParameters::getRole, 0)
                .parameter(QueryGroupsUsersParameters::getLimit, 1)
                .parameter(QueryGroupsUsersParameters::getOffset, 0)
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过组织Login 获取组织成员信息
     */
    @Test
    public void testClientGroupsUsersByLogin2() {
        ResultList<GroupUser> result = YuQueClient.query(getConfig()).groupsUsers("rpzx2t")
                .parameter(QueryGroupsUsersParameters::getRole, 0)
                .parameter(QueryGroupsUsersParameters::getLimit, 1)
                .parameter(QueryGroupsUsersParameters::getOffset, 0)
                .run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户Id 获取某个用户的加入的组织列表
     */
    @Test
    public void testClientUsersGroupById() {
        ResultList<User> result = YuQueClient.query(getConfig()).usersGroup("84161").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过用户Login 获取某个用户的加入的组织列表
     */
    @Test
    public void testClientUsersGroupByLogin() {
        ResultList<User> result = YuQueClient.query(getConfig()).usersGroup("momozzz").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 更新
     */
    @Test
    public void testClientUpdateGroupsUsersByLogin(){
        Result<GroupUser> result = YuQueClient.update(getConfig()).groupsUsers("afx-ued2","momozzz").run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 删除
     */
    @Test
    public void testClientDeleteGroupsUsersByLogin(){
        Result<GroupUser> result = YuQueClient.delete(getConfig()).groupsUsers("140148","momozzz").run();
        Assert.assertEquals(200, result.getStatus());
    }
}