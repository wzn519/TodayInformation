package com.hencoder.wzn.todayinformation.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.hencoder.wzn.todayinformation.R;
import com.hencoder.wzn.todayinformation.main.MainActivity;
import com.hencoder.wzn.todayinformation.base.BaseActivity;
import com.hencoder.wzn.todayinformation.inject.ViewInject;

import java.io.File;

import butterknife.BindView;

/*利用注解来注入主布局的id*/
@ViewInject(mainLayoutById = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {

    @BindView(R.id.vv_splash)
    FullScreenVideoView mVideoView;
    @BindView(R.id.tv_time)
    TextView mTvTimer;
    /*Timer计时器的P层*/
    private ISplashActivityContract.IPresenter timerPresenter;

    @Override
    protected void afterBindView() {
             /*计时器*/
        initTimerPresenter();
        /*设置点击事件*/
        initListener();
        /*初始化视频*/
        initVideo();
        
    }

    private void initVideo() {
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.doudou));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    /*创建Timer的Presenter对象*/
    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }

    private void initListener() {
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    /*为视频设置播放URL的方法*/
    public void setVideoURI(Uri parse) {
        mVideoView.setVideoURI(parse);
        videoViewPrepared();
    }

    /*视频准备播放的方法*/
    private void videoViewPrepared() {
        /*设置视频播放---需要调用监听方法*/
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        videoViewCompletion();
    }

    /*视频播放完成的方法*/
    private void videoViewCompletion() {
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    /*设置计时器的显示值*/
    @Override
    public void setTvTimer(String timer) {
        mTvTimer.setText(timer);
    }
}
