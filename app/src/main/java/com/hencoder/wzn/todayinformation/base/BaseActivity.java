package com.hencoder.wzn.todayinformation.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hencoder.wzn.todayinformation.inject.ViewInject;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

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
                ButterKnife.bind(this);
            } else {
                throw new RuntimeException("当前布局id不存在");
            }
        } else {
            throw new RuntimeException("当前注解为null");
        }
    }
}
