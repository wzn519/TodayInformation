package com.hencoder.wzn.todayinformation.mvp;

/**
 * Created by wzn on 2019/6/11.
 * 抽象同事
 * ---------什么是同事对象---------------------
 * 这些对象既会影响别的对象，也会被你别的对象所影响，这样的对象叫同事(Colleague)对象
 */

public interface IMvpView {
    /*获取静态代理的Controller*/
    MvpController getController();
}
