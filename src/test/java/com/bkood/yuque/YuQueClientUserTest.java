package com.bkood.yuque;

import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static com.bkood.yuque.TestConfig.getConfig;

/**
 * User - 用户
 */
public class YuQueClientUserTest {

    /**
     * 获取认证的用户的个人信息
     */
    @Test
    public void testClientUser() {
        Result<User> result = YuQueClient.query(getConfig()).user().run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过ID获取个人信息
     */
    @Test
    public void testClientUsersById() {
        Result<User> result = YuQueClient.query(getConfig()).users(TestConfig.id).run();
        Assert.assertEquals(200, result.getStatus());
    }

    /**
     * 通过Login获取个人信息
     */
    @Test
    public void testClientUsersByLogin() {
        Result<User> result = YuQueClient.query(getConfig()).users(TestConfig.login).run();
        Assert.assertEquals(200, result.getStatus());
    }

}