package com.hencoder.wzn.todayinformation.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hencoder.wzn.todayinformation.R;
import com.hencoder.wzn.todayinformation.view.CustomCountDownTimer;
import com.hencoder.wzn.todayinformation.view.FullScreenVideoView;


public class SplashActivity extends Activity {

    private FullScreenVideoView mVideoView;
    private MediaPlayer mMediaPlayer;
    private TextView mTvTimer;
    private CustomCountDownTimer mCountDownTimer;
    private final int countDownTimer = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mTvTimer = (TextView) findViewById(R.id.tv_time);
        /*计时器*/
        setCountDownTimer();
        setVideoView();
    }

    private void setCountDownTimer() {
        mCountDownTimer = new CustomCountDownTimer(countDownTimer, new CustomCountDownTimer.ICountDownTimeListener() {
            @Override
            public void onTick(int time) {
                mTvTimer.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mTvTimer.setText("跳过");
            }
        });
        mCountDownTimer.start();

        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*匿名内部类，SplashActivity.this这个才是指向SplashActivity这个类的*/
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
    }

    private void setVideoView() {
        /*fbc+enter，快捷键找到View*/
        mVideoView = (FullScreenVideoView) findViewById(R.id.vv_splash);
        String url = "android.resource://" + getPackageName() + "/" + R.raw.doudou;
        Log.e("路径", "onCreate:---> " + url);
        /*设置视频路径*/
        Uri parse = Uri.parse(url);
        mVideoView.setVideoURI(parse);
        /*设置视频播放---需要调用监听方法*/
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                SplashActivity.this.mMediaPlayer = mp;
                mp.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*重新播放*/
        if (mMediaPlayer != null) {
            mMediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*暂停播放*/
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    /**
     * 用于Activity被销毁时，保存当前的状态值
     *//*
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
        mMediaPlayer = null;
        mCountDownTimer.cancel();
    }

}
