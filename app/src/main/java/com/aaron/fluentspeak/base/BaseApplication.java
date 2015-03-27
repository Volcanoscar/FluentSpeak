package com.aaron.fluentspeak.base;

import android.app.Application;
import android.content.Context;

/**
 * Created on 下午10:08.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class BaseApplication extends Application {
    private static Application sApp;
    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }

    /**
     * @return 返回应用的上下文资源
     */
    public static Context getContext() {
        return sApp.getApplicationContext();
    }
}
