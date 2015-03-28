package com.aaron.fluentspeak.http.result;

import com.aaron.fluentspeak.http.BaseResult;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 下午2:34.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class WeatherResult extends BaseResult {

    @SerializedName("forecast")
    private ForecastData mForecastData;
    @SerializedName("realtime")
    private RealTimeData mRealTimeData;

    public ForecastData getForecastData() {
        return mForecastData;
    }

    public RealTimeData getRealTimeData() {
        return mRealTimeData;
    }
}
