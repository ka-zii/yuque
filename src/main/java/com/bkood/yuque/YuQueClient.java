package com.bkood.yuque;

import com.bkood.yuque.common.Config;
import com.bkood.yuque.models.Add;
import com.bkood.yuque.models.Delete;
import com.bkood.yuque.models.Query;
import com.bkood.yuque.models.Update;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.bkood.yuque.common.YuQueConstants.*;

/**
 * YuQueClient是使用SDK的入口<br/>
 * <p>
 * 入口主要提供CRUD相关调用类的入口:
 * </p>
 * <pre>
 * 新增：{@link #add(Config)}
 * 删除：{@link #delete(Config)}
 * 更新：{@link #update(Config)}
 * 查询：{@link #query(Config)}
 * </pre>
 * 例如需要调用查询：<br/>
 * YuQueClient.query(Config.builder().***.build()).run()
 */
public class YuQueClient {

    /**
     * 配置类
     */
    private final Config config;

    /**
     * YuQueClient 构造方法
     *
     * @param config {@link Config} 用于请求的配置文件
     */
    public YuQueClient(Config config) {
        // 如果配置为空那么就提示异常
        if (config == null) {
            throw new RuntimeException("请传入Config");
        }
        // 构建基础请求头
        Map<String, String> baseHeader = new HashMap<>();
        baseHeader.put(userAgent, config.getUserAgent());
        baseHeader.put(token, config.getToken());
        baseHeader.put(contentType, jsonMime);
        baseHeader.putAll(Optional.ofNullable(config.getHeader()).orElse(new HashMap<>(1)));
        // 构建配置
        this.config = Config.builder().baseUrl(Optional.ofNullable(config.getBaseUrl()).orElse(BASE_URL)).userAgent(config.getUserAgent()).token(config.getToken()).header(baseHeader).build();
    }

    /**
     * 查询静态方法 <br/>
     * 调用方式：YuQueClient.query(config)
     *
     * @param config {@link Config} 用于请求的配置文件
     * @return {@link Query} 查询集合对象
     */
    public static Query query(Config config) {
        YuQueClient yuQueClient = new YuQueClient(config);
        return new Query(yuQueClient.config);
    }

    /**
     * 添加静态方法<br/>
     * 调用方式：YuQueClient.add(config)
     *
     * @param config {@link Config} 用于请求的配置文件
     * @return {@link Add} 新增集合对象
     */
    public static Add add(Config config) {
        YuQueClient yuQueClient = new YuQueClient(config);
        return new Add(yuQueClient.config);
    }

    /**
     * 更新静态方法<br/>
     * 调用方式：YuQueClient.update(config)
     *
     * @param config {@link Config} 用于请求的配置文件
     * @return {@link Update} 更新集合对象
     */
    public static Update update(Config config) {
        YuQueClient yuQueClient = new YuQueClient(config);
        return new Update(yuQueClient.config);
    }

    /**
     * 删除静态方法<br/>
     * 调用方式：YuQueClient.delete(config)
     *
     * @param config {@link Config} 用于请求的配置文件
     * @return {@link Delete} 更新集合对象
     */
    public static Delete delete(Config config) {
        YuQueClient yuQueClient = new YuQueClient(config);
        return new Delete(yuQueClient.config);
    }

}
