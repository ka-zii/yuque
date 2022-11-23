package com.bkood.yuque.parameters.query;

import lombok.Data;

/**
 * 获取某个用户知识库列表
 * <a href="https://www.yuque.com/yuque/developer/repo#Parameters">Parameters</a>
 */
@Data
public class QueryUsersReposParameters {

    /**
     * Book, Design, all - 所有类型
     */
    private String type;

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
