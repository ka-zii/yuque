package com.bkood.yuque.common;

import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;

/**
 * 返回一个实体
 *
 * @param <T>
 */
@Getter
public class Result<T> {

    /**
     * http状态码
     */
    private final int status;

    /**
     * 没有经过处理的消息体
     */
    private final String body;

    /**
     * 处理后的实体
     */
    private T entity;

    public Result(HttpResponse result, Class<T> tClass) {
        this.status = result.getStatus();
        this.body = result.body();
        if (this.status == 200) {
            this.entity = Utils.getJsonDataObject(JSONObject.parseObject(this.body), tClass);
        }
    }

}
