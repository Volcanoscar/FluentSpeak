package com.aaron.fluentspeak.module.animation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaron.fluentspeak.R;
import com.aaron.fluentspeak.base.BaseActivity;

/**
 * Created on 上午12:59.
 *
 * @author ran.huang
 * @version 1.0.0
 */
public class CountDownAnimationActivity extends BaseActivity {

    private ImageView mImageView;
    private TextView mTextView;
    private Animation mCountDownAnimation;
    private Animation mBackgroundFadeoutAnimation;
    private Animation mTextFadeoutAnimation;
    private int mTime = 3;
    private static final long START_COUNT_DOWN_DELAY_MILLISECOND = 1000;
    private static final int WHAT_ANIMATION_MESSAGE = 1;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == WHAT_ANIMATION_MESSAGE) {
                mTextView.setText(mTime + "");
                if (mTime == 1) {
                    mTextView.startAnimation(mTextFadeoutAnimation);
                    mImageView.startAnimation(mBackgroundFadeoutAnimation);
                } else {
                    mImageView.startAnimation(mCountDownAnimation);
                    mTime--;
                    sendEmptyMessageDelayed(1, START_COUNT_DOWN_DELAY_MILLISECOND);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_animation);
        initViews();
        initAnimations();
    }

    private void initAnimations() {
        mCountDownAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_count_down);
        mBackgroundFadeoutAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_count_down_fade_out);
        mTextFadeoutAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_count_down_text);
    }

    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.image_view_count_down);
        mTextView = (TextView) findViewById(R.id.text_view_count_down);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.sendEmptyMessage(WHAT_ANIMATION_MESSAGE);
    }

}
