package com.bkood.yuque.models.update;

import com.bkood.yuque.common.AbstractRequestParametersData;
import com.bkood.yuque.common.Config;
import com.bkood.yuque.common.HttpMethod;
import com.bkood.yuque.common.Result;
import com.bkood.yuque.entity.DocDetail;
import com.bkood.yuque.parameters.update.UpdateReposDocParameters;

/**
 * 更新文档 <a href="https://www.yuque.com/yuque/developer/doc#c2e9ee2a">Doc</a><br/>
 * 需要 Doc 的 abilities.update 权限<br/>
 * 注意! 这里最后个参数是 id （文档编号）而不是 slug，原因是为了避免 slug 改变无法正确保存。
 *
 */
public class UpdateReposDocs extends AbstractRequestParametersData<UpdateReposDocParameters, Result<DocDetail>> {

    /**
     * 请求路径
     */
    public static final String URL = "/repos/{0}/docs/{1}";



    /**
     * 请求基础构造
     * @param repoIdOrNamespace 仓库编号(bookId仓库编号，就是 repoId) 或 namespace（仓库的唯一名称）
     * @param id 文档编号 ID
     * @param config {@link Config} 配置
     */
    public UpdateReposDocs(String repoIdOrNamespace, String id, Config config) {
        setConfigToRequest(toUrl(config.getBaseUrl(), URL, repoIdOrNamespace, id), config);
    }

    @Override
    public Result<DocDetail> run() {
        return new Result<>(execute(HttpMethod.PUT), DocDetail.class);
    }
}
