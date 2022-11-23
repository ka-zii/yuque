package com.bkood.yuque.parameters.add;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 团队创建知识库
 * <a href="https://www.yuque.com/yuque/developer/repo#Parameters-1">Parameters</a>
 */
@Data
public class AddGroupsReposParameters {

    /**
     * 仓库名称
     */
    private String name;

    /**
     * slug
     */
    private String slug;

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

    /**
     * ‘Book’ 文库, ‘Design’ 画板, 请注意大小写
     */
    private String type;


    public Integer getPublic() {
        return publicType;
    }

    public void setPublic(Integer publicType) {
        this.publicType = publicType;
    }

}
