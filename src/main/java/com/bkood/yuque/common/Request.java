package com.bkood.yuque.common;


import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.MessageFormat;
import java.util.Objects;


/**
 * 请求体接口
 * 通过封装请求接口实现解耦，如果更换工具类，用户调用部分可以不做修改
 * @param <T> 返回的泛型
 */
public abstract class Request<T> {

    /**
     * 声明 request
     */
    okhttp3.Request.Builder request = new okhttp3.Request.Builder();

    /**
     * 声明 client
     */
    OkHttpClient.Builder client =  new OkHttpClient().newBuilder();

    /**
     * 构建url
     */
    StringBuffer url = new StringBuffer();

    /**
     * 调用运行接口，需要在此接口实现http的调用
     *
     * @return 泛型的实体
     */
    public abstract T run();

    /**
     * 将url拼接成整体<br/>
     * 例：<br/>
     * 我们要将：http://bkood.com/:aa/:bb/test 中的:aa,:bb 替换成其他文字<br/>
     * 那么我们就可以把:aa,:bb 替换成下面方式：<br/>
     * http://bkood.com/:aa/:bb/test -> http://bkood.com/{0}/{1}/test <br/>
     * 接着调用方法：toUrl("http://bkood.com","/{0}/{1}/test",1,2)<br/>
     * 这时返回的值就是一个替换后的URL：http://bkood.com/1/2/test
     *
     * @param baseUrl 基础路径
     * @param url 路径
     * @param args 变量
     * @return url
     */
    public String toUrl(String baseUrl, String url, Object... args) {
        return baseUrl + MessageFormat.format(url, args);
    }

    /**
     * 通过Http方法 构建入参并请求
     * @param method {@link HttpMethod} Http方法
     * @return {@link ResponseInfo} 返回消息
     */
    public ResponseInfo execute(HttpMethod method) {
        // 设置请求方式
        if(HttpMethod.POST.equals(method)){
            this.request.url(this.url.toString()).post(new FormBody.Builder().build());
        } else if(HttpMethod.PUT.equals(method)){
            this.request.url(this.url.toString()).put(new FormBody.Builder().build());
        } else if(HttpMethod.DELETE.equals(method)){
            this.request.url(this.url.toString()).delete();
        } else if(HttpMethod.GET.equals(method)){
            this.request.url(this.url.toString()).get();
        }
        // 调用执行发送
        return execute();
    }

    /**
     * 直接请求
     * @return {@link ResponseInfo} 返回消息
     */
    public ResponseInfo execute() {
        // 构建并发送请求
        try (Response response = client.build().newCall(this.request.build()).execute()){
            String body = Objects.requireNonNull(response.body()).string();
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setBody(body);
            responseInfo.setStatus(response.code());
            return responseInfo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将配置设置到请求类
     *
     * @param url 请求链接
     * @param config {@link Config}
     */
    public void setConfigToRequest(String url, Config config) {
        // 设置URL
        this.url.append(url);
        // 设置头
        this.request.headers(Headers.of(config.getHeader()));
        // 设置代理
        if(config.getProxyHost() != null && config.getProxyHost().trim().length() > 0){
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress( config.getProxyHost(),config.getProxyPort()));
            this.client.proxy(proxy);
        }
    }

}
