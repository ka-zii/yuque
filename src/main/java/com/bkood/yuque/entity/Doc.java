package com.bkood.yuque.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 文档基本信息
 * <a href="https://www.yuque.com/yuque/developer/docserializer">DocSerializer</a>
 */
@Data
public class Doc {

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
     * 文档创建人
     */
    Long userId;

    /**
     * 描述了正文的格式
     * <li>asl</li>
     * <li>markdown</li>
     */
    String format;

    /**
     * 公开状态<br/>
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
     * 文档内容更新时间
     */
    Date contentUpdatedAt;

    /**
     * 所属知识库
     */
    Book book;

    /**
     * 所属团队（个人）
     */
    User user;

    /**
     * 最后修改人
     */
    User lastEditor;

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
