package com.bkood.yuque.common;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import com.alibaba.fastjson2.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.bkood.yuque.common.Utils.getFunctionName;

/**
 * 带有请求体的接口
 * P 代表入参类型
 * T 代表出参类型
 */
public interface RequestParameters<P, T> extends Request<T> {

    /**
     * 入参
     */
    Map<String, Object> parameters = new HashMap<>();

    /**
     * 提供Lambda方式入参信息<br/>
     * 例：
     * 我想要设置 AddGroupsReposParameters类的name属性，那么写法就是
     * parameter(AddGroupsReposParameters::getName, "test")
     *
     * @param key P 泛型类的get方法
     * @param val 值
     * @return {@link RequestParameters}
     */
    default RequestParameters<P, T> parameter(SFunction<P, ?> key, Object val) {
        parameters.put(getFunctionName(key), val);
        return this;
    }

    /**
     * 提供方式入参信息
     *
     * @param key map 键
     * @param val map 值
     * @return {@link RequestParameters}
     */
    default RequestParameters<P, T> parameter(String key, Object val) {
        parameters.put(key, val);
        return this;
    }

    /**
     * 提供bean方式入参
     * @param parameters P 泛型类作为入参
     * @return {@link RequestParameters}
     */
    default RequestParameters<P, T> parameter(P parameters) {
        this.parameters.putAll(BeanUtil.beanToMap(parameters, true, false));
        return this;
    }

    /**
     * 获取接口全部变量<br/>
     * 如果想要更改变量请使用:<br/>
     * {@link #parameter(SFunction, Object)},{@link #parameter(String, Object) },{@link #parameter(Object)}
     * @return 不可更改的属性
     */
    default Map<String, Object> getParameters(){
        return Collections.unmodifiableMap(parameters);
    }

    /**
     * 执行http请求，重写父级方法
     *
     * @param request {@link HttpRequest}
     * @return {@link HttpResponse}
     */
    @Override
    default HttpResponse execute(HttpRequest request) {
        // 1.判断表单是否为空
        if(this.parameters.size() == 0){
            return request.execute();
        }
        // 2.判断请求方式，如果post、put那么就转换为json
        if (Method.POST.equals(request.getMethod()) || Method.PUT.equals(request.getMethod())){
            request.body(JSONObject.toJSONString(this.parameters));
        } else {
            request.form(this.parameters);
        }
        return request.execute();
    }

}
