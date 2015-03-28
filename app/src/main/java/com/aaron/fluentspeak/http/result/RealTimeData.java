package com.aaron.fluentspeak.http.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created on 下午2:58.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class RealTimeData implements Serializable {
    @SerializedName("weather")
    private String mWeather;

    public String getWeather() {
        return mWeather;
    }
}
