package com.aaron.fluentspeak.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.aaron.fluentspeak.base.BaseApplication;

/**
 * Created on 下午9:26.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class ResourceUtils {
    /**
     *
     * @return 获取Resuorce
     */
    private static Resources getResources() {
        return BaseApplication.getContext().getResources();
    }

    /**
     *
     * @param resId 资源Id
     * @return 本地资源图片
     */
    public static Drawable getDrawable(int resId) {
        return getResources().getDrawable(resId);
    }

    /**
     *
     * @param resId 资源Id
     * @return 本地字符串内容
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     *
     * @param resId 资源Id
     * @return dimens大小，如果单位不是px,会将单位换算成px返回
     */
    public static int getDimen(int resId) {
        return (int)getResources().getDimension(resId);
    }
}
