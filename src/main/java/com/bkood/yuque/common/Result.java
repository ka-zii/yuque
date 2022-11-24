package com.bkood.yuque.common;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;

/**
 * 返回一个实体
 *
 * @param <T>
 */
@Getter
public class Result<T> extends ResponseInfo{

    /**
     * 处理后的实体
     */
    private T entity;

    public Result(ResponseInfo result, Class<T> tClass) {
        super(result);
        if (result.getStatus() == 200) {
            this.entity = Utils.getJsonDataObject(JSONObject.parseObject(result.getBody()), tClass);
        }
    }

}
