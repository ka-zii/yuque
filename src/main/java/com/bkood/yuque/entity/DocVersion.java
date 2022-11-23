package com.bkood.yuque.entity;

import lombok.Data;

import java.util.Date;

/**
 * 文档版本基本信息
 * <a href="https://www.yuque.com/yuque/developer/docversionserializer">DocVersionSerializer</a>
 */
@Data
public class DocVersion {

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
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;
}
