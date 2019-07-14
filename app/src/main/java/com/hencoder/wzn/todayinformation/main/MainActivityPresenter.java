package com.hencoder.wzn.todayinformation.main;

import android.support.v4.app.Fragment;

import com.hencoder.wzn.todayinformation.R;
import com.hencoder.wzn.todayinformation.base.BaseMvpPresenter;
import com.hencoder.wzn.todayinformation.main.beijing.BeiJingFragment;
import com.hencoder.wzn.todayinformation.main.hangzhou.HangZhouFragment;
import com.hencoder.wzn.todayinformation.main.shanghai.ShanghaiFragment;
import com.hencoder.wzn.todayinformation.main.shenzhen.ShenZhenFragment;
import com.hencoder.wzn.todayinformation.main.tools.MainConstantsTool;

/**
 * Created by wzn on 2019/7/11.
 * 首页Presenter
 */

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {
    private int mCurrentFragmentIndex;
    /*用于存放所有Fragment的数组*/
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentContainerId;
    private int mTopPosition;
    private int mBottomPosition;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initMainFragment() {
        //记录当前Fragment的角标
        mCurrentFragmentIndex = MainConstantsTool.SHANGHAI;
        replaceFragment(mCurrentFragmentIndex);
    }

    @Override
    public int getCurrentCheckedIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mFragments[i] != null && mCurrentFragmentIndex != i) {
                //隐藏非当前的所有Fragment
                hideFragment((mFragments[i]));
            }
        }
        //隐藏其他的Fragment后，显示当前的Fragment
        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            //更新角标
            setCurrentCheck(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            //更新角标
            setCurrentCheck(mCurrentFragmentIndex);
        }
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }


    /**
     * 记录当前的角标
     *
     * @param fragmentIndex
     */
    private void setCurrentCheck(int fragmentIndex) {
        this.mCurrentFragmentIndex = fragmentIndex;
        switch (fragmentIndex) {
            case MainConstantsTool.SHANGHAI:
                mCurrentContainerId = R.id.main_top_rb_shanghai;
                mTopPosition = MainConstantsTool.SHANGHAI;
                break;
            case MainConstantsTool.HANGZHOU:
                mCurrentContainerId = R.id.main_top_rb_hangzhou;
                mTopPosition = MainConstantsTool.HANGZHOU;
                break;
            case MainConstantsTool.BEIJING:
                mCurrentContainerId = R.id.main_top_rb_beijing;
                mBottomPosition = MainConstantsTool.BEIJING;
                break;
            case MainConstantsTool.SHENZHEN:
                mCurrentContainerId = R.id.main_top_rb_shenzhen;
                mBottomPosition = MainConstantsTool.SHENZHEN;
                break;
        }
    }

    /**
     * 创建Fragment
     *
     * @param mCurrentFragmentIndex
     */
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case MainConstantsTool.SHANGHAI://上海讯息的Fragment
                fragment = new ShanghaiFragment();
                break;
            case MainConstantsTool.HANGZHOU://杭州讯息的Fragment
                fragment = new HangZhouFragment();
                break;
            case MainConstantsTool.BEIJING:
                fragment = new BeiJingFragment();
                break;
            case MainConstantsTool.SHENZHEN:
                fragment = new ShenZhenFragment();
                break;
        }
        //将Fragment添加到数组中
        mFragments[mCurrentFragmentIndex] = fragment;
        //显示Fragment
        addAndShowFragment(fragment);
    }

    /**
     * 添加并显示Fragment
     *
     * @param fragment
     */
    private void addAndShowFragment(Fragment fragment) {
        //当前的Fragment已经被添加，则直接显示
        if (fragment.isAdded()) {
            getView().showFragment(fragment);
            //添加Fragment
        } else {
            getView().addFragment(fragment);
        }

    }

    /**
     * 隐藏Fragment
     *
     * @param fragment
     */
    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }
    }
}
