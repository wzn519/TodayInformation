package com.hencoder.wzn.todayinformation.splash;


import com.hencoder.wzn.todayinformation.mvp.ILifeCircle;
import com.hencoder.wzn.todayinformation.mvp.IMvpView;
import com.hencoder.wzn.todayinformation.mvp.MvpController;

/**
 * Created by anson on 2018/10/28.
 */
public interface ISplashActivityContract {

    // @MvpEmptyViewFactory
    interface IView extends IMvpView {
        /*用于设置倒计时的值*/
        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCircle {
        /*用于初始化定时器*/
        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpController getController() {
            return null;
        }
    };
}
