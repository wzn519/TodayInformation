package com.hencoder.wzn.todayinformation.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hencoder.wzn.todayinformation.mvp.IMvpView;
import com.hencoder.wzn.todayinformation.mvp.MvpController;

/**
 * Created by wzn on 2019/6/14.
 * MVP框架中View的基类---》实现抽象同事
 * 用于关联V层和P层的生命周期
 */

public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {
    private MvpController mMvpController;
    /*获取静态代理的Controller*/
    @Override
    public MvpController getController() {
        if (this.mMvpController == null) {
            this.mMvpController = new MvpController();
        }
        return mMvpController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onCreate(savedInstanceState, intent, null);
            mvpController.onActivityCreate(savedInstanceState, intent, null);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onDestroy();
        }
        Log.e("LifeCircleMvpActivity", "onDestroy: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onNewIntent(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onActivityResult(requestCode,resultCode,data);
        }
    }

}
