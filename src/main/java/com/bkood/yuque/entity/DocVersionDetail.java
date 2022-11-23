package com.bkood.yuque.entity;

import lombok.Data;

import java.util.Date;

/**
 * 文档版本详细信息
 * <a href="https://www.yuque.com/yuque/developer/docversiondetailserializer">DocVersionDetailSerializer</a>
 */
@Data
public class DocVersionDetail {

    /**
     * 草稿编号
     */
    Long id;

    /**
     * 文档编号
     */
    Long docId;

    /**
     * 文档路径
     */
    String slug;

    /**
     * 标题
     */
    String title;

    /**
     * 文档创建人
     */
    Long userId;

    /**
     * 创建人
     */
    User user;

    /**
     * 是否是草稿
     */
    Integer draft;

    /**
     * 正文 Markdown 源代码
     */
    String body;

    /**
     * 正文 Asl 格式
     */
    String bodyAsl;

    /**
     * 正文 HTML 代码
     */
    String bodyHtml;

    /**
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;

}
