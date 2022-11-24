package com.bkood.yuque.common;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;

import java.util.List;

/**
 * 返回一个数组实体
 *
 * @param <T>
 */
@Getter
public class ResultList<T> extends ResponseInfo{

    /**
     * 处理后的数组实体
     */
    private List<T> entity;

    public ResultList(ResponseInfo result, Class<T> tClass) {
        super(result);
        if (result.getStatus() == 200) {
            this.entity = Utils.getJsonArrayDataObject(JSONObject.parseObject(result.getBody()), tClass);
        }
    }

}
