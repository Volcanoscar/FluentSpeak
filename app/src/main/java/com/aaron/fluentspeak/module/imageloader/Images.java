package com.aaron.fluentspeak.module.imageloader;

import android.util.SparseArray;

import com.aaron.fluentspeak.R;

/**
 * Created on 下午11:27.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class Images {

    /**
     * 图片Url
     */
    private static SparseArray<String> sImages = new SparseArray<String>(3);

    static {
        sImages.put(R.id.image_view_first,
                "http://image.ku.91rb.com/kuplay/uploads/images/app_icon/2014/03/31/08/d85fbdf481e1fd15f3cc001d51590e9f_175_175.png");
        sImages.put(R.id.image_view_second,
                "http://www.xuanyouwang.com/img/13655260842.jpg");
        sImages.put(R.id.image_view_third,
                "http://img5.imgtn.bdimg.com/it/u=2008239786,3570767787&fm=21&gp=0.jpg");
    }

    /**
     *
     * @return 获取图片Url集合
     */
    public static SparseArray<String> getsImages() {
        return sImages;
    }


}
