package com.hencoder.wzn.todayinformation.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hencoder.wzn.todayinformation.inject.ViewInject;
import com.hencoder.wzn.todayinformation.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment {

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*获取注解*/
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        View mView = null;
        if (annotation != null) {
            /*获取在子类中注入的ID*/
            int layoutById = annotation.mainLayoutById();
            if (layoutById > 0) {
                mView = initFragmentView(inflater, layoutById);
                bindView(mView);
                afterBindView();
            } else {
                throw new RuntimeException("当前布局id不存在");
            }
        } else {
            throw new RuntimeException("当前注解为null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int layoutById) {
        return inflater.inflate(layoutById, null);
    }

    // View 的依赖注入绑定
    private void bindView(View mView) {
        ButterKnife.bind(this, mView);
    }

    /*利用模版方法设计模式，来统一处理Fragment中的初始化工作
    * 它的含义是：父类定义一套规则，具体由各个子类来实现这些方法
    * */
    protected abstract void afterBindView();
}
