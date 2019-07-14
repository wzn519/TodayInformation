package com.hencoder.wzn.todayinformation.splash;

import android.util.Log;

import com.hencoder.wzn.todayinformation.base.BaseMvpPresenter;

/**
 * Created by wzn on 2019/6/11.
 * 强引用对象时，当二者的生命周期，不一致时，长生命周期对象，持有了短生命周期对象，那么就容易发生内存泄漏
 * 利用中介者设计模式，同步调用生命周期的方法，来避免发生内存泄漏
 * ---------中介者设计模式的要点---------------
 * 1.抽象中介者(抽象类或接口)
 * 2.具体的中介者--》具体的功能模块
 * 3.抽象同事
 * 4.具体同事
 */

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {


    private final int countDownTimer = 5;
    private CustomCountDownTimer mCountDownTimer;

    public SplashTimerPresenter(ISplashActivityContract.IView view) {
        super(view);
    }


    public void initTimer() {
        mCountDownTimer = new CustomCountDownTimer(countDownTimer, new CustomCountDownTimer.ICountDownTimeListener() {
            @Override
            public void onTick(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });
        mCountDownTimer.start();
    }

    /*销毁计时器*/
    public void cancel() {
        mCountDownTimer.cancel();
    }

    /**
     * 为了防止出现空指针异常                                M    B
     * @return
     */
    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("AAAA", "onDestroy: ");
    }
}
