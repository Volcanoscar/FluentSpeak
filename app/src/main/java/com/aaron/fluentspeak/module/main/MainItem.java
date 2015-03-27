package com.aaron.fluentspeak.module.main;

/**
 * Created on 14-11-17.
 * @author ran.huang
 * @version 1.0.0
 */
public class MainItem {

    /**设备信息*/
    public final static int POSITION_XIAOMI_WEATHER = 0;
    /**测试ListAdapter*/
    public final static int POSITION_ANIMATION = POSITION_XIAOMI_WEATHER + 1;
    /**捕捉全局异常Demo*/
    public final static int POSITION_IMAGE_LOADER = POSITION_ANIMATION + 1;
    private String mValue;
    private String mDescription;

    /**
     * Constructor
     * @param value 主页列表项文本
     * @param description 列表项详细描述
     */
    public MainItem(String value, String description) {
        mValue = value;
        mDescription = description;
    }

    /**
     * @return 获取文本
     */
    public String getValue() {
        return mValue;
    }

    /**
     *
     * @return 获取详细描述
     */
    public String getDescription() {
        return mDescription;
    }
}
