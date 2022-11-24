package com.bkood.yuque.common;

import com.alibaba.fastjson2.JSON;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.bkood.yuque.common.Utils.getFunctionName;
import static com.bkood.yuque.common.YuQueConstants.jsonMime;

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
     * 获取接口全部变量<br/>
     * 如果想要更改变量请使用:<br/>
     * {@link #parameter(SFunction, Object)},{@link #parameter(String, Object)}}
     * @return 不可更改的属性
     */
    default Map<String, Object> getParameters(){
        return Collections.unmodifiableMap(parameters);
    }

    /**
     * 重写父级方法 通过Http方法 构建入参并请求
     * @param method {@link HttpMethod} Http方法
     * @return {@link ResponseInfo} 返回消息
     */
    @Override
    default ResponseInfo execute(HttpMethod method) {
        // 设置请求方式
        if(HttpMethod.POST.equals(method)){
            this.request.url(url.toString())
                    .post(RequestBody.create(JSON.toJSONString(parameters) , MediaType.parse(jsonMime)));
        } else if(HttpMethod.PUT.equals(method)){
            this.request
                    .url(url.toString())
                    .put(RequestBody.create(JSON.toJSONString(parameters) , MediaType.parse(jsonMime)));
        } else if(HttpMethod.DELETE.equals(method)){
            HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url.toString())).newBuilder();
            parameters.forEach((k,v)-> urlBuilder.addQueryParameter(k,String.valueOf(v)));
            this.request.url(urlBuilder.build()).delete();
        } else if(HttpMethod.GET.equals(method)){
            HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url.toString())).newBuilder();
            parameters.forEach((k,v)-> urlBuilder.addQueryParameter(k,String.valueOf(v)));
            this.request.url(urlBuilder.build()).get();
        }
        // 调用执行发送
        return execute();
    }

}
