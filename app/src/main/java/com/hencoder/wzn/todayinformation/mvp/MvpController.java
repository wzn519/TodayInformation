package com.hencoder.wzn.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.hencoder.wzn.todayinformation.mvp.presenter.LifeCircleMvpPresenter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wzn on 2019/6/14.
 * 用于控制View的生命周期
 */

public class MvpController implements ILifeCircle {

    /*存放的是P层的实例，用于对于多P层的情况*/
    private Set<ILifeCircle> lifeCircles = new HashSet<>();

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument) {
        //从Set中取出当前的ILifeCircle对象
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArgument == null) {
                getArgument = new Bundle();
            }
            next.onCreate(savedInstanceState, intent, getArgument);
        }
    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArgument == null) {
                getArgument = new Bundle();
            }
            next.onCreate(savedInstanceState, intent, getArgument);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.onDestroy();
        }
    }

    @Override
    public void onDestroyView() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.onDestroyView();
        }
    }

    @Override
    public void viewOnDestroy() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.viewOnDestroy();
        }
        lifeCircles.clear();
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            next.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            if (data == null) {
                data = new Intent();
            }
            next.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            if (outState == null) {
                outState = new Bundle();
            }
            next.onSaveInstanceState(outState);
        }
    }

    @Override
    public void attachView(IMvpView mvpView) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle next = iterator.next();
            next.attachView(mvpView);
        }
    }

    public void savePresenter(ILifeCircle lifeCircle) {
        lifeCircles.add(lifeCircle);
    }
}
