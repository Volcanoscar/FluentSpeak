package com.aaron.fluentspeak.module.imageloader;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aaron.fluentspeak.R;
import com.aaron.fluentspeak.base.BaseActivity;
import com.aaron.fluentspeak.utils.ResourceUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created on 下午10:57.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class ImageLoaderActivity extends BaseActivity {


    private ImageLoader mImageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        initImageLoader();
        initViews();
    }

    private void initImageLoader() {
        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(ImageLoaderConfiguration.createDefault(this));
    }

    private void initViews() {
        ImageView firstImageView = (ImageView) findViewById(R.id.image_view_first);
        ImageView secondImageView = (ImageView) findViewById(R.id.image_view_second);
        ImageView thirdImageView = (ImageView) findViewById(R.id.image_view_third);
        loadImage(firstImageView);
        loadImage(secondImageView);
        loadImage(thirdImageView);
    }

    private void loadImage(final ImageView imageView) {
        String uri = Images.getsImages().get(imageView.getId());
        mImageLoader.loadImage(uri,
                new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {

                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        setImageViewWithFitSize(imageView, loadedImage);
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {

                    }
                });

    }

    /**
     * 根据Bitmap资源大小调整ImageView高度，并且设置ImageView内容
     * @param imageView ImageView
     * @param loadedImage Bitmap resource
     */
    private void setImageViewWithFitSize(ImageView imageView, Bitmap loadedImage) {
        int viewWidth = ResourceUtils.getDimen(R.dimen.image_loader_view_width);
        float scale = (float)viewWidth / loadedImage.getWidth();
        int viewHeight = (int)(loadedImage.getHeight() * scale);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)imageView.getLayoutParams();
        lp.height = viewHeight;

        imageView.setImageBitmap(loadedImage);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**TODO must be recycle ImageView bitmap resource*/
    }
}
