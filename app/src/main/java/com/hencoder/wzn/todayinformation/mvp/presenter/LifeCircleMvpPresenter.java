package com.hencoder.wzn.todayinformation.mvp.presenter;

import com.hencoder.wzn.todayinformation.mvp.ILifeCircle;
import com.hencoder.wzn.todayinformation.mvp.IMvpView;
import com.hencoder.wzn.todayinformation.mvp.MvpController;

import java.lang.ref.WeakReference;

/**
 * Created by wzn on 2019/6/11.
 * 抽象中介者
 */

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {
    //传入T，获取它的地方不用强转
    private WeakReference<T> mWeakReference;

    protected LifeCircleMvpPresenter() {
        super();
    }

    public LifeCircleMvpPresenter(IMvpView mvpView) {
        super();
        attachView(mvpView);
        /*获取管理生命周期的Controller对象*/
        MvpController controller = mvpView.getController();
        controller.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView IMvpView) {
        /*实现IMvpView对象的弱引用，避免内存泄漏*/
        if (mWeakReference == null) {
            mWeakReference = new WeakReference(IMvpView);
        } else {
            T view = mWeakReference.get();
            if (!(view instanceof IMvpView)) {
                mWeakReference = new WeakReference(IMvpView);
            }
        }
    }

    /**
     * 用于P层获取View层，抽象都Presenter的抽象层中
     *
     * @return
     */
    protected T getView() {
        /*获取当前持有的弱引用对象*/
        T view = mWeakReference != null ? mWeakReference.get() : null;
        if (view == null) {
            /*显示空视图,需要在子类中实现*/
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();

    /**
     * 用于回收对象
     */
    @Override
    public void onDestroy() {
        mWeakReference = null;
    }
}
