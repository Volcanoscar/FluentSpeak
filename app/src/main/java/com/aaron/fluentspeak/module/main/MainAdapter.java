package com.aaron.fluentspeak.module.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aaron.fluentspeak.R;
import com.aaron.fluentspeak.utils.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import com.aaron.fluentspeak.*;

/**
 * Created on 2015/3/27.
 * 主界面适配器
 * @author ran.huang
 * @version 1.0.0
 */
public class MainAdapter extends BaseAdapter {
    private List<MainItem> mItemList;
    private Context mContext;

    /**
     * 构造器
     * @param context 上下文资源
     * @param itemList 主页列表项
     */
    public MainAdapter(Context context, List<MainItem> itemList) {
        if (itemList == null) {
            throw new NullPointerException("Demo Main Adapter data list must not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("Adapter Context must not be null");
        }
        mContext = context;
        mItemList = new ArrayList<MainItem>(itemList);
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        int size = ResourceUtils.getDimen(R.dimen.textsize_main_adapter_item);
        int padding = ResourceUtils.getDimen(R.dimen.textpadding_main_adapter_item);
        textView.setTextSize(size);
        textView.setPadding(padding, padding, padding, padding);
        MainItem item = mItemList.get(position);
        if (item != null) {
            textView.setText((position + 1) + "." + mItemList.get(position).getValue());
        }
        return textView;
    }
}
