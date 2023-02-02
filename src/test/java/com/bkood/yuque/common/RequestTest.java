package com.bkood.yuque.common;

import org.junit.Assert;
import org.junit.Test;

public class RequestTest {

    @Test
    public void testToUrl() {
        String baseUrl = "https://bkood.com";
        String url = "/{0}/test/{1}";
        RequestTestUnit testUnit = new RequestTestUnit();
        String returnUrl = testUnit.toUrl(baseUrl, url, "a","b");
        Assert.assertEquals("https://bkood.com/a/test/b", returnUrl);
    }

    public static class RequestTestUnit extends AbstractRequestData<Object> {

        @Override
        public Object run() {
            return null;
        }
    }
}