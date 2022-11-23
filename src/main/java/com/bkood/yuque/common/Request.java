package com.bkood.yuque.common;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.text.MessageFormat;


/**
 * 请求体接口
 * 通过封装请求接口实现解耦，如果更换工具类，用户调用部分可以不做修改
 * @param <T> 返回的泛型
 */
public interface Request<T> {

    /**
     * 调用运行接口，需要在此接口实现http的调用
     *
     * @return 泛型的实体
     */
    T run();

    /**
     * 将url拼接成整体<br/>
     * 例：<br/>
     * 我们要将：http://bkood.com/:aa/:bb/test中的:aa,:bb 替换成其他文字<br/>
     * 那么我们就可以把:aa,:bb 替换成下面方式：<br/>
     * http://bkood.com/:aa/:bb/test -> http://bkood.com/{0}/{1}/test<br/>
     * 接着调用方法：toUrl("http://bkood.com","/{0}/{1}/test",1,2)<br/>
     * 这时返回的值就是一个替换后的URL：http://bkood.com/1/2/test
     *
     * @param baseUrl 基础路径
     * @param url 路径
     * @param args 变量
     * @return url
     */
    default String toUrl(String baseUrl, String url, Object... args) {
        return baseUrl + MessageFormat.format(url, args);
    }

    /**
     * 执行请求
     *
     * @param request {@link HttpRequest}
     * @return {@link HttpResponse}
     */
    default HttpResponse execute(HttpRequest request) {
        return request.execute();
    }

    /**
     * 将配置设置到请求类
     *
     * @param request {@link HttpRequest}
     * @param config {@link Config}
     */
    default void setConfigToRequest(HttpRequest request, Config config) {
        if (request == null) {
            throw new RuntimeException("HttpRequest 入参为 null");
        }
        // 设置头
        request.addHeaders(config.getHeader());
        // 设置代理
        if (StrUtil.isNotEmpty(config.getProxyHost())) {
            request.setHttpProxy(config.getProxyHost(), config.getProxyPort());
        }
    }

}
