package com.example.scout.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.scout.R;
import com.example.scout.common.BaseActivity;

/**
 * Created by zhangyuanyuan on 2017/9/25.
 */

public class SplashActivity extends BaseActivity {


    private ImageView ivSplash;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        ivSplash = (ImageView) findViewById(R.id.iv_splash);

        RequestOptions requestOptions = new RequestOptions()
                .skipMemoryCache(true);
        Glide.with(this)
                .load(R.mipmap.splash_bg)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade(2000))//淡入淡出100m
                .into(ivSplash);
        mHandler.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    protected void initDb() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

}
