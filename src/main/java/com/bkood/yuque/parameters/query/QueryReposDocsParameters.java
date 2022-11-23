package com.bkood.yuque.parameters.query;

import lombok.Data;

/**
 * 获取一个仓库的文档列表
 * <a href="https://www.yuque.com/yuque/developer/doc#6d560c5e">Parameters</a>
 */
@Data
public class QueryReposDocsParameters {

    /**
     * 获取文档浏览数
     * 传递 optional_properties=hits 获取文档浏览数
     */
    String optionalProperties;

    /**
     * 从第几条开始取数据
     */
    Integer offset;

    /**
     * 取几条数据
     * max: 500
     */
    Integer limit;
}
