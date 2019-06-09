package com.hencoder.wzn.todayinformation.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hencoder.wzn.todayinformation.R;
import com.hencoder.wzn.todayinformation.base.BaseActivity;
import com.hencoder.wzn.todayinformation.inject.ViewInject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ViewInject(mainLayoutById = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_top_fab)
    FloatingActionButton mTopFab;
    @BindView(R.id.main_top_rb_shanghai)
    RadioButton mTopRbShanghai;
    @BindView(R.id.main_top_rb_hangzhou)
    RadioButton mTopRbHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup mRgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout mFlMainBottom;

    @OnClick(R.id.main_top_fab)
    public void onClick() {
    }
}
