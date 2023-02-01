package com.bkood.yuque.common;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

/**
 * YuQueClient 配置
 */
@Getter
@Builder
public class Config {

    /**
     * 获取 Token 可通过点击语雀的个人头像，并进入 个人设置 页面拿到:<br/>
     * 详细介绍请访问语雀文档：<a href="https://www.yuque.com/yuque/developer/api">Overview</a>
     */
    String token;

    /**
     * 可以自由设置基础请求URL<br/>
     * 如果不传默认地址为：{@link YuQueConstants#BASE_URL}
     */
    String baseUrl;

    /**
     * 设置自定义头
     */
    Map<String, String> header;

    /**
     * 代理地址
     */
    String proxyHost;

    /**
     * 代理端口
     */
    int proxyPort;
}
