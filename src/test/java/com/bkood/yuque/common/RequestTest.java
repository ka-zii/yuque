package com.bkood.yuque.common;

import cn.hutool.http.HttpRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RequestTest {

    @Test
    public void testToUrl() {
        String baseUrl = "https://bkood.com";
        String url = "/{0}/test/{1}";
        RequestTestUnit testUnit = new RequestTestUnit();
        String returnUrl = testUnit.toUrl(baseUrl, url, "a","b");
        Assert.assertEquals("https://bkood.com/a/test/b", returnUrl);
    }

    @Test
    public void testSetConfigToRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("a","b");
        Config config = Config.builder()
                .header(map)
                .build();
        HttpRequest request = HttpRequest.post("https://bkood.com");
        RequestTestUnit testUnit = new RequestTestUnit();
        testUnit.setConfigToRequest(request, config);
        Assert.assertEquals("b", request.header("a"));
    }

    public static class RequestTestUnit implements Request<Object>{

        @Override
        public Object run() {
            return null;
        }
    }
}