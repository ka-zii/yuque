package com.bkood.yuque.common;

import com.alibaba.fastjson2.JSONObject;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 工具类
 */
public class Utils {

    /**
     * 返回值外部key
     */
    private static final String BODY_DATA = "data";

    /**
     * 获取JSON key为data 的数据
     *
     * @param jsonObject 需要处理的Json
     * @param tClass 需要转换的类
     * @param <T> 转换类型
     * @return 转换后类
     */
    public static <T> T getJsonDataObject(JSONObject jsonObject, Class<T> tClass) {
        return jsonObject.getObject(BODY_DATA, tClass);
    }

    /**
     * 获取JSON key为data 的数据
     *
     * @param jsonObject 需要处理的Json
     * @param tClass 需要转换的类
     * @param <T> 转换类型
     * @return 转换后列表
     */
    public static <T> List<T> getJsonArrayDataObject(JSONObject jsonObject, Class<T> tClass) {
        return jsonObject.getList(BODY_DATA, tClass);
    }

    /**
     * 读取Function中的名字<br/>
     * 当前方法写的比较狭窄，没有过多的兼容场景，所以有一些限制：<br/>
     * <pre>
     *     1.必须是get为前缀的入参 getX
     *     2.驼峰结构会转换为下划线 getTestName -> test_name
     *     3.所有参数会变为小写
     * <pre/>
     * @param func get方法
     * @return 转换后的名字，如果异常返回null
     */
    public static <P> String getFunctionName(SFunction<P, ?> func) {
        SerializedLambda serializedLambda;
        try {
            // 反射读取
            Method method = func.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            serializedLambda = (SerializedLambda) method.invoke(func);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
        String methodName = serializedLambda.getImplMethodName();
        if(!methodName.startsWith("get")){
            throw new RuntimeException("请使用get方法作为入参");
        }
        String separator = "_";
        return serializedLambda.getImplMethodName().substring(3)
                .replaceAll("([a-z])([A-Z])", "$1" + separator + "$2")
                .toLowerCase();
    }
}
