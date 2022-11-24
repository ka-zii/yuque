package com.bkood.yuque.common;

import lombok.Data;

/**
 * 返回消息
 */
@Data
public class ResponseInfo {

    /**
     * http状态码
     */
    private int status;

    /**
     * 没有经过处理的消息体
     */
    private String body;
    public ResponseInfo(){}

    /**
     * 拷贝自己
     * @param responseInfo {@link ResponseInfo}
     */
    public ResponseInfo(ResponseInfo responseInfo){
        this.body = responseInfo.getBody();
        this.status = responseInfo.getStatus();
    }

}
