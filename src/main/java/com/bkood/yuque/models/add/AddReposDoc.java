package com.bkood.yuque.models.add;

import com.bkood.yuque.common.AbstractRequestParametersData;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.DocDetail;
import com.bkood.yuque.parameters.add.AddReposDocParameters;

/**
 * 创建文档 <a href="https://www.yuque.com/yuque/developer/doc#63851c78">Doc</a> <br/>
 * 需要 Repo 的 abilities.doc.create 权限
 */
public class AddReposDoc extends AbstractRequestParametersData<AddReposDocParameters, Result<DocDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}/docs";



    /**
     * 请求基础构造
     * @param idOrNamespace 用户id 或 namespace（仓库的唯一名称）
     * @param config {@link Config} 配置
     */
    public AddReposDoc(String idOrNamespace, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, idOrNamespace), config);
    }

    @Override
    public Result<DocDetail> run() {
        return new Result<>(execute(HttpMethod.POST), DocDetail.class);
    }
}
