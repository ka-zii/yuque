package com.bkood.yuque.common;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UtilsTest {

    @Test
    public void testJsonDataObject() {
        JSONObject jsonObject = new JSONObject();
        JSONObject dataJsonObject = new JSONObject();
        dataJsonObject.put("name","thisIsName");
        jsonObject.put("data",dataJsonObject);
        UtilsTestUnit utilsTestUnit = Utils.getJsonDataObject(jsonObject, UtilsTestUnit.class);
        Assert.assertEquals("thisIsName", utilsTestUnit.getName());
    }

    @Test
    public void testJsonArrayDataObject() {
        JSONObject jsonObject = new JSONObject();
        JSONObject dataJsonObject = new JSONObject();
        dataJsonObject.put("name","thisIsName");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(dataJsonObject);
        jsonObject.put("data",jsonArray);
        List<UtilsTestUnit> utilsTestUnits = Utils.getJsonArrayDataObject(jsonObject, UtilsTestUnit.class);
        Assert.assertEquals("thisIsName", utilsTestUnits.get(0).getName());
    }

    @Test
    public void testFunctionName() {
        String name = Utils.getFunctionName(UtilsTestUnit::getName);
        Assert.assertEquals("name", name);
        name = Utils.getFunctionName(UtilsTestUnit::getHumpName);
        Assert.assertEquals("hump_name", name);
    }

    @Data
    private static class UtilsTestUnit{
        private String name;

        private String humpName;
    }
}