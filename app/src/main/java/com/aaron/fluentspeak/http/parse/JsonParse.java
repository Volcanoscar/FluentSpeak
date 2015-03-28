package com.aaron.fluentspeak.http.parse;

import com.aaron.fluentspeak.http.BaseResult;
import com.google.gson.Gson;

/**
 * Json解析
 * @param <T> BaseResult
 * @author ran.huang
 * @version 1.0.0
 */
public class JsonParse<T extends BaseResult> implements Parse {
    private Class<T> mCls;


    /**
     * Constructor
     * @param cls Class<T>
     */
    public JsonParse(Class<T> cls) {
        mCls = cls;
    }

    @Override
    public T parse(Object object) {
        String str = (String)object;
        Gson gson = new Gson();
        return gson.fromJson(str, mCls);
    }
}
