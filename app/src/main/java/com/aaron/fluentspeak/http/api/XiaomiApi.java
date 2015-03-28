package com.aaron.fluentspeak.http.api;

import com.aaron.fluentspeak.http.Request;
import com.aaron.fluentspeak.http.RequestCallback;
import com.loopj.android.http.RequestParams;

/**
 * Created on 下午12:50.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class XiaomiApi {
    /**小米天气*/
    private static final String  URL_XIAOMI_WEATHER = "wtr-v2/weather";




    private static final String KEY_CITY_ID = "cityId";
    private static final String KEY_IMEI = "imei";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_MIUI_VERSION = "miuiVersion";
    private static final String KEY_MOD_DEVICE = "modDevice";
    private static final String KEY_SOURCE = "source";

    private static final long ID_CITY = 101010100;

    /**
     * 小米天气接口
     * @param callback 请求回调
     */
    public static void getXiaomiWeather(RequestCallback callback) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(KEY_CITY_ID, ID_CITY);
        requestParams.put(KEY_IMEI, "529e2dd3d767bdd3595eec30dd481050");
        requestParams.put(KEY_DEVICE, "pisces");
        requestParams.put(KEY_MIUI_VERSION, "JXCCNBD20.0");
        requestParams.put(KEY_MOD_DEVICE, "");
        requestParams.put(KEY_SOURCE, "m");
        Request.get(URL_XIAOMI_WEATHER, requestParams, callback);
    }
}
