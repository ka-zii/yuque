package com.bkood.yuque.common;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class RequestParametersTest {


    /**
     * 测试入参
     */
    @Test
    public void testParameter(){
        RequestParametersTestUnit requestParametersTestUnit = new RequestParametersTestUnit();
        // 测试 Lambda
        requestParametersTestUnit.parameter(RequestTestParameters::getTest, "test");
        requestParametersTestUnit.parameter(RequestTestParameters::getTestLambda, "testLambda");
        // 测试 k v
        requestParametersTestUnit.parameter("testKey","testValue");
        Map<String, Object> parameters = requestParametersTestUnit.getParameters();
        Assert.assertEquals("test", parameters.get("test"));
        Assert.assertEquals("testLambda", parameters.get("test_lambda"));
        Assert.assertEquals("testValue", parameters.get("testKey"));
    }


    @Data
    public static class RequestTestParameters {

            private String test;

            private String testLambda;

            private String testBean;
    }

    public static class RequestParametersTestUnit extends AbstractRequestParametersData<RequestTestParameters,Object> {

        @Override
        public Object run() {
            return null;
        }
    }
}