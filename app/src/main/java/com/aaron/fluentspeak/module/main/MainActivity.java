package com.aaron.fluentspeak.module.main;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aaron.fluentspeak.R;
import com.aaron.fluentspeak.base.BaseActivity;
import com.aaron.fluentspeak.utils.PopupUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2015/3/27.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class MainActivity extends BaseActivity {

    private ListView mListView;
    private MainAdapter mMainAdapter;

    private List<MainItem> mMainItems = new ArrayList<MainItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }

    /**
     * 初始化列表项数据
     */
    private void initData() {
        String[] titles = getResources().getStringArray(R.array.main_item_title);
        String[] descriptions = getResources().getStringArray(R.array.main_item_description);
        int itemLength = titles.length;
        MainItem mainItem;
        for (int i = 0; i < itemLength; i++) {
            mainItem = new MainItem(titles[i], descriptions[i]);
            mMainItems.add(mainItem);
        }
    }

    private void initViews() {
        initListView();
    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.listview_demo_main);
        mMainAdapter = new MainAdapter(this, mMainItems);
        mListView.setAdapter(mMainAdapter);
        mListView.setOnItemClickListener(mOnItemClickListener);
        mListView.setOnItemLongClickListener(mOnItemLongClickListener);
    }

    private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch ((int) id) {
                case MainItem.POSITION_XIAOMI_WEATHER:

                    break;
                case MainItem.POSITION_ANIMATION:

                    break;
                case MainItem.POSITION_IMAGE_LOADER:

                    break;
                default:
                    break;
            }
        }
    };

    private final AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            int index = (int)id;
            MainItem mainItem = mMainItems.get(index);
            PopupUtils.showToast(mainItem.getDescription());
            return true;
        }
    };

}
