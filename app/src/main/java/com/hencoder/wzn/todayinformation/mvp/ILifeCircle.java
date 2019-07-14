package com.hencoder.wzn.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.hencoder.wzn.todayinformation.mvp.presenter.LifeCircleMvpPresenter;

/**
 * Created by wzn on 2019/6/11.
 * 用于管理Activity和Fragment的生命周期
 * 抽象中介者
 * 通过这些方法来改变同事类中的行为
 */

public interface ILifeCircle {
    /*为了兼容Fragment*/
    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument);

    void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onDestroyView();

    void viewOnDestroy();

    void onNewIntent(Intent intent);


    /**
     * Activity界面跳转到其他界面，返回数据
     *
     * @param requestCode 请求码
     * @param resultCode  结果码
     * @param data        返回的数据
     */
    void onActivityResult(int requestCode, int resultCode, Intent data);

    /**
     * 保存Activity的状态
     *
     * @param outState 状态值
     */
    void onSaveInstanceState(Bundle outState);


    void attachView(IMvpView mvpView);


}
