package com.hencoder.wzn.todayinformation.base;

import android.content.Intent;
import android.os.Bundle;

import com.hencoder.wzn.todayinformation.mvp.IMvpView;
import com.hencoder.wzn.todayinformation.mvp.presenter.LifeCircleMvpPresenter;

/**
 * Created by wzn on 2019/6/13.
 * 作为抽象中介者和具体中介者的一个桥接类(即是P层的中间层),用于管理Activity和Fragment的生命周期方法
 */

public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCircleMvpPresenter<T> {

    //用于关联生命周期管理方法
    public BaseMvpPresenter(T view) {
        super(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void viewOnDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }


}
