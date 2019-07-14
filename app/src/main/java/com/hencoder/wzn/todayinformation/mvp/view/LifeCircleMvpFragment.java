package com.hencoder.wzn.todayinformation.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hencoder.wzn.todayinformation.mvp.IMvpView;
import com.hencoder.wzn.todayinformation.mvp.MvpController;

/**
 * Created by wzn on 2019/6/14.
 * MVP框架中View的基类---》实现抽象同事
 * 用于关联V层和P层的生命周期
 */

public class LifeCircleMvpFragment extends Fragment implements IMvpView {
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onCreate(savedInstanceState, null, bundle);
            mvpController.onActivityCreate(savedInstanceState, null, bundle);
        }
    }

    //走到这个方法时， 表示View已经创建
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onActivityCreate(savedInstanceState, null, bundle);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onDestroy();
        }
        Log.e("LifeCircleMvpActivity", "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onDestroyView();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onSaveInstanceState(outState);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = getController();
        if (mvpController != null) {
            mvpController.onActivityResult(requestCode, resultCode, data);
        }
    }

}
