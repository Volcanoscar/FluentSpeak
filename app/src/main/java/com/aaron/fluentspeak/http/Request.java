package com.aaron.fluentspeak.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

/**
 * Created on 下午12:39.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class Request {
    private static final String BASE_URL = "http://weatherapi.market.xiaomi.com/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * GET请求
     * @param url 请求地址
     * @param params 请求参数
     * @param responseHandler 请求回调
     */
    public static void get(String url, RequestParams params, RequestCallback responseHandler) {
        /**TODO 在此添加获取数据逻辑，先取缓存，若没有，则再从网络获取*/
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    /**
     * POST请求
     * @param url 请求地址
     * @param params 请求参数
     * @param responseHandler 请求回调
     */
    public static void post(String url, RequestParams params, RequestCallback responseHandler) {
        /**TODO 在此添加获取数据逻辑，先取缓存，若没有，则再从网络获取*/
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
