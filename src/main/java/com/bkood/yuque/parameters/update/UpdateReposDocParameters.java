package com.bkood.yuque.parameters.update;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

/**
 * 更新文档
 * <a href="https://www.yuque.com/yuque/developer/doc#Parameters-2">Parameters</a>
 */
@Data
public class UpdateReposDocParameters {

    /**
     * 标题
     */
    private String title;

    /**
     * 文档 Slug
     */
    private String slug;


    /**
     * 已发布的正文 Markdown，这个字段必传
     */
    private String body;

    /**
     * 如果在页面编辑过文档，那这时文档会转成 lake 格式，如果再用 markdown 无法进行更新，这是需要添加
     * _force_asl = 1 来确保内容的正确转换。
     */
    @Getter(AccessLevel.NONE)
    private String forceAsl;

    public String get_ForceAsl() {
        return forceAsl;
    }


}
