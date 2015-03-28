package com.aaron.fluentspeak.module.xiaomi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aaron.fluentspeak.R;
import com.aaron.fluentspeak.base.BaseActivity;
import com.aaron.fluentspeak.http.RequestCallback;
import com.aaron.fluentspeak.http.api.XiaomiApi;
import com.aaron.fluentspeak.http.result.WeatherResult;
import com.aaron.fluentspeak.utils.PopupUtils;

/**
 * Created on 下午12:03.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class XiaomiWeatherActivity extends BaseActivity implements View.OnClickListener {

    private TextView mCityTextView;
    private TextView mWeatherTextView;

    private final RequestCallback mRequestCallback = new RequestCallback<WeatherResult>(this, WeatherResult.class) {

        @Override
        public void onSuccess(WeatherResult result) {
            updateContentView(result);
        }

        @Override
        public void onFailure(int statusCode) {
            PopupUtils.showToast(getString(R.string.request_fail));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaomi_weather);
        Log.e("aaron", "onCreate()");
        initViews();
    }

    private void initViews() {
        mCityTextView = (TextView) findViewById(R.id.text_view_xiaomi_city);
        mWeatherTextView = (TextView) findViewById(R.id.text_view_xiaomi_weather);
        Button requestButton = (Button) findViewById(R.id.button_xiaomi_request);
        requestButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        XiaomiApi.getXiaomiWeather(mRequestCallback);
    }

    private void updateContentView(WeatherResult result) {
        mCityTextView.setText(getString(R.string.mi_city_text, result.getForecastData().getCity()));
        mWeatherTextView.setText(getString(R.string.mi_weather_text, result.getRealTimeData().getWeather()));
    }
}
