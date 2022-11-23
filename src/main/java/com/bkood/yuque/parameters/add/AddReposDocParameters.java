package com.bkood.yuque.parameters.add;

import lombok.Data;

/**
 * 创建文档
 * <a href="https://www.yuque.com/yuque/developer/doc#Parameters-1">Parameters</a>
 */
@Data
public class AddReposDocParameters {

    /**
     * 标题
     */
    private String title;

    /**
     * 文档 Slug
     */
    private String slug;


    /**
     * 支持 markdown、lake、html，默认为 markdown
     */
    private String format;

    /**
     * format 描述的正文内容，最大允许 5MB
     */
    private String body;


}
