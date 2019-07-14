package com.hencoder.wzn.todayinformation.base;

import android.os.Bundle;

import com.hencoder.wzn.todayinformation.inject.ViewInject;
import com.hencoder.wzn.todayinformation.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*获取注解*/
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            /*获取在子类中注入的ID*/
            int layoutById = annotation.mainLayoutById();
            if (layoutById > 0) {
                setContentView(layoutById);
                bindView();
                afterBindView();
            } else {
                throw new RuntimeException("当前布局id不存在");
            }
        } else {
            throw new RuntimeException("当前注解为null");
        }
    }
    // View 的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);
    }
    /*利用模版方法设计模式，来统一处理Activity中的初始化工作
    * 它的含义是：父类定义一套规则，具体由各个子类来实现这些方法
    * */
    protected abstract void afterBindView();
}
