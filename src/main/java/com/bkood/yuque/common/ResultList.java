package com.bkood.yuque.common;

import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;

import java.util.List;

/**
 * 返回一个数组实体
 *
 * @param <T>
 */
@Getter
public class ResultList<T> {

    /**
     * http状态码
     */
    private final int status;

    /**
     * 没有经过处理的消息体
     */
    private final String body;

    /**
     * 处理后的数组实体
     */
    private List<T> entity;

    public ResultList(HttpResponse result, Class<T> tClass) {
        this.status = result.getStatus();
        this.body = result.body();
        if (this.status == 200) {
            this.entity = Utils.getJsonArrayDataObject(JSONObject.parseObject(this.body), tClass);
        }
    }

}
