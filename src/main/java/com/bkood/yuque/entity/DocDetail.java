package com.bkood.yuque.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 文档详细信息
 * <a href="https://www.yuque.com/yuque/developer/docdetailserializer">DocDetailSerializer</a>
 */
@Data
public class DocDetail {

    /**
     * 文档编号
     */
    Long id;

    /**
     * 文档路径
     */
    String slug;

    /**
     * 标题
     */
    String title;

    /**
     * 仓库编号，就是 repoId
     */
    Long bookId;

    /**
     * 仓库信息，就是 repo 信息
     */
    Book book;

    /**
     * 用户/团队编号
     */
    Long userId;

    /**
     * 用户/团队信息
     */
    User user;

    /**
     * 描述了正文的格式
     * <li>lake</li>
     * <li>markdown</li>
     */
    String format;

    /**
     * 正文 Markdown 源代码
     */
    String body;

    /**
     * 草稿 Markdown 源代码
     */
    String bodyDraft;

    /**
     * 转换过后的正文 HTML
     */
    String bodyHtml;

    /**
     * 语雀 lake 格式的文档内容
     */
    String bodyLake;

    /**
     * 文档创建人 User Id
     */
    Long creatorId;

    /**
     * 公开级别<br/>
     * 因为public是java的保留字段，所以起了别名publicType<br/>
     * public => publicType
     * <li>1 - 公开</li>
     * <li>0 - 私密</li>
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    Integer publicType;

    /**
     * 状态
     * <li>1 - 正常</li>
     * <li>0 - 草稿</li>
     */
    Integer status;

    /**
     * 评论数量
     */
    Integer likesCount;

    /**
     * 评论数量
     */
    Integer commentsCount;

    /**
     * 文档内容更新时间
     */
    Date contentUpdatedAt;

    /**
     * 删除时间，未删除为 null
     */
    Date deletedAt;

    /**
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;

    public Integer getPublic() {
        return publicType;
    }

    public void setPublic(Integer publicType) {
        this.publicType = publicType;
    }
}
