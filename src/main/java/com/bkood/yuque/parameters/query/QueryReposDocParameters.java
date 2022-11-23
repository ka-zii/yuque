package com.bkood.yuque.parameters.query;

import lombok.Data;

/**
 * 获取单篇文档的详细信息
 * <a href="https://www.yuque.com/yuque/developer/doc#Parameters">Parameters</a>
 */
@Data
public class QueryReposDocParameters {

    /**
     * 返回文档最原始的格式
     * raw=1
     */
    String raw;
}
