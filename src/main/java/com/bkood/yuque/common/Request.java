package com.bkood.yuque.common;


/**
 * 请求体接口
 * 通过封装请求接口实现解耦
 * @param <T> 返回的泛型
 */
public interface Request<T> {


    /**
     * 调用运行接口，需要在此接口实现http的调用
     *
     * @return 泛型的实体
     */
    T run();

}
