package com.hencoder.wzn.todayinformation.main;


import android.support.v4.app.Fragment;

import com.hencoder.wzn.todayinformation.mvp.ILifeCircle;
import com.hencoder.wzn.todayinformation.mvp.IMvpView;
import com.hencoder.wzn.todayinformation.mvp.MvpController;

/**
 * Created by anson on 2018/10/28.
 */
public interface IMainActivityContract {

    // @MvpEmptyViewFactory
    interface IView extends IMvpView {
        /**
         * 显示Fragment
         *
         * @param fragment
         */
        void showFragment(Fragment fragment);

        /**
         * 添加Fragment
         *
         * @param fragment
         */
        void addFragment(Fragment fragment);

        /**
         * 隐藏Fragment
         *
         * @param fragment
         */
        void hideFragment(Fragment fragment);
    }

    interface IPresenter extends ILifeCircle {
        //初始化Fragment方法--->这个是个桥梁，实际的初始化在Presenter类中
        void initMainFragment();

        /*获取当前Fragment的索引位置*/
        int getCurrentCheckedIndex();

        /*切换Fragment*/
        void replaceFragment(int mCurrentFragmentIndex);
        /*记录上面的RadioButton被选中*/
        int getTopPosition();
        /*记录下面的RadioButton被选中*/
        int getBottomPosition();
    }

    IView emptyView = new IView() {

        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getController() {
            return null;
        }
    };
}
