package com.bkood.yuque.parameters.update;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新知识库信息
 * <a href="https://www.yuque.com/yuque/developer/repo#Parameters-3">Parameters</a>
 */
@Data
public class UpdateReposParameters {

    /**
     * 仓库名称
     */
    private String name;

    /**
     * slug
     */
    private String slug;


    /**
     * 更新文档仓库的目录信息
     */
    private String toc;

    /**
     * 说明
     */
    private String description;

    /**
     * <li>0 私密</li>
     * <li>1 所有人可见</li>
     * <li>2 空间成员可见</li>
     * <li>3 空间所有人（含外部联系人）可见</li>
     * <li>4 知识库成员可见</li>
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer publicType;


    public Integer getPublic() {
        return publicType;
    }

    public void setPublic(Integer publicType) {
        this.publicType = publicType;
    }
}
