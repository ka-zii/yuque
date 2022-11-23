package com.bkood.yuque.parameters.query;

import lombok.Data;

/**
 * 获取知识库详情
 * <a href="https://www.yuque.com/yuque/developer/repo#Parameters-2">Parameters</a>
 */
@Data
public class QueryReposParameters {

    /**
     * 仓库类型
     * <li>Book - 文库</li>
     * <li>Design - 设计稿</li>
     */
    private String type;

}
