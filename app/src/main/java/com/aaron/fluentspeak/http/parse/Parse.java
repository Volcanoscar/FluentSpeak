package com.aaron.fluentspeak.http.parse;

import com.aaron.fluentspeak.http.BaseResult;

/**
 * Created on 下午2:31.
 *
 * 解析接口
 * @param <T> BaseResult
 *
 * @author ran.huang
 * @version 1.0.0
 */
public interface Parse<T extends BaseResult> {
    /**
     * 解析
     * @param object Object
     * @return BaseResult
     */
    abstract T parse(Object object);
}
