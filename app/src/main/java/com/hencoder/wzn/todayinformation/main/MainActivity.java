package com.hencoder.wzn.todayinformation.main;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hencoder.wzn.todayinformation.R;
import com.hencoder.wzn.todayinformation.base.BaseActivity;
import com.hencoder.wzn.todayinformation.inject.ViewInject;
import com.hencoder.wzn.todayinformation.main.tools.MainConstantsTool;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutById = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView {

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);
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
    @BindView(R.id.main_top_rb_beijing)
    RadioButton mainTopRbBeijing;
    @BindView(R.id.main_top_rb_shenzhen)
    RadioButton mainTopRbShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    private boolean isChangeTopOrBottom;

    @Override
    protected void afterBindView() {
        //初始化Fragment
        initMainFragment();
        changeAnim(rgMainBottom, mRgMainTop);
    }

    private void initMainFragment() {
        //在Presenter中完成Fragment的初始化
        mPresenter.initMainFragment();
    }

    @OnClick(R.id.main_top_fab)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_top_fab:
                /*记录切换状态的*/
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnim(mRgMainTop, rgMainBottom);
                    handleTopPosition();
                } else {
                    changeAnim(rgMainBottom, mRgMainTop);
                }
                break;
        }
    }

    /*
    *切换Fragment的显示，隐藏顶部的，显示底部的
    * 上海  杭州
    * */
    private void handleTopPosition() {
        if (mPresenter.getTopPosition() != 1) {
            mPresenter.replaceFragment(MainConstantsTool.SHANGHAI);
            /*设置RadioButton被选中*/
            mTopRbShanghai.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainConstantsTool.HANGZHOU);
            mTopRbHangzhou.setChecked(true);
        }
    }

    /**
     * 切换显示  深圳   北京
     */
    private void handleBottomPosition() {
        if (mPresenter.getBottomPosition() != 3) {
            mPresenter.replaceFragment(MainConstantsTool.BEIJING);
            /*设置被选中的RadioButton*/
            mainTopRbBeijing.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainConstantsTool.SHENZHEN);
              /*设置被选中的RadioButton*/
            mainTopRbShenzhen.setChecked(true);
        }
    }


    /**
     * 切换的动画
     *
     * @param gone 消失的radioGroup
     * @param show 显现的radioGroup
     */
    private void changeAnim(RadioGroup gone, RadioGroup show) {
        /*隐藏的动画*/
        gone.clearAnimation();
        Animation goneAnim = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(goneAnim);
        gone.setVisibility(View.GONE);
        show.clearAnimation();
        Animation showAnim = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(showAnim);
        show.setVisibility(View.VISIBLE);
    }

    /**
     * 显示当前的Fragment
     *
     * @param fragment
     */
    @Override
    public void showFragment(Fragment fragment) {
        /*必须提交;否则无法显示*/
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    /**
     * 添加Fragment到栈中
     *
     * @param fragment
     */
    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fr_main_content, fragment).commit();
    }

    /**
     * 隐藏Fragment
     *
     * @param fragment
     */
    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment);
    }
}
