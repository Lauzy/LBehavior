package com.lauzy.freedom.lbehavior.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;

import com.lauzy.freedom.lbehavior.R;
import com.lauzy.freedom.lbehavior.fragment.Demo1Fragment;
import com.lauzy.freedom.lbehavior.fragment.Demo2Fragment;
import com.lauzy.freedom.lbehavior.fragment.Demo3Fragment;
import com.lauzy.freedom.lbehavior.fragment.Demo4Fragment;
import com.lauzy.freedom.lbehaviorlib.behavior.CommonBehavior;


public class Demo3ActivityWithFragment extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private FrameLayout mFrameLayout;
    private Demo1Fragment mDemo1Fragment;
    private Demo2Fragment mDemo2Fragment;
    private Demo3Fragment mDemo3Fragment;
    private Demo4Fragment mDemo4Fragment;
    private Toolbar mToolbar;
    private CommonBehavior mToolBarBehavior;
    private BottomNavigationView mBottomMainNavigation;
    private CommonBehavior mBottomBehavior;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo_fragment_activity);
        mFrameLayout = findViewById(R.id.frame_main);
        mFloatingActionButton = findViewById(R.id.fab_mode);
        mToolbar = findViewById(R.id.toolbar_common);
        mBottomMainNavigation = findViewById(R.id.bottom_main_navigation);
        loadFragment(savedInstanceState);

        mToolBarBehavior = CommonBehavior.from(mToolbar);
        mBottomBehavior = CommonBehavior.from(mBottomMainNavigation);
        MenuItem item = mBottomMainNavigation.getMenu().getItem(0);
        onNavigationItemSelected(item);//默认选中第一个
        mBottomMainNavigation.setOnNavigationItemSelectedListener(this);

        mToolBarBehavior.setMinScrollY(50);
        mToolBarBehavior.setScrollYDistance(100);
        mToolBarBehavior.setDuration(1000);
        mToolBarBehavior.setInterpolator(new BounceInterpolator());

        mBottomBehavior.setMinScrollY(20);
        mBottomBehavior.setScrollYDistance(100);
        mBottomBehavior.setDuration(1000);
        mBottomBehavior.setInterpolator(new BounceInterpolator());

        CommonBehavior floatActionBehavior = CommonBehavior.from(mFloatingActionButton);
        floatActionBehavior.setMinScrollY(20);
        floatActionBehavior.setScrollYDistance(100);
        floatActionBehavior.setDuration(1000);
        floatActionBehavior.setInterpolator(new BounceInterpolator());
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (item.getItemId()) {
            case R.id.menu_main_item_beauty:
                mToolbar.setVisibility(View.VISIBLE);
                mToolBarBehavior.isEnableScroll(true);
                transaction.show(mDemo1Fragment).hide(mDemo2Fragment)
                        .hide(mDemo3Fragment).hide(mDemo4Fragment);
                break;
            case R.id.menu_main_item_android:
                mToolbar.setVisibility(View.VISIBLE);
                mToolBarBehavior.isEnableScroll(false);
                transaction.show(mDemo2Fragment).hide(mDemo3Fragment)
                        .hide(mDemo1Fragment).hide(mDemo4Fragment);
                break;
            case R.id.menu_main_item_category:
                mToolbar.setVisibility(View.GONE);//隐藏测试fragment中动画
                mToolBarBehavior.isEnableScroll(false);
                transaction.show(mDemo3Fragment).hide(mDemo2Fragment)
                        .hide(mDemo1Fragment).hide(mDemo4Fragment);
                break;
            case R.id.menu_main_item_mine:
                mToolbar.setVisibility(View.VISIBLE);
                transaction.show(mDemo4Fragment).hide(mDemo3Fragment)
                        .hide(mDemo1Fragment).hide(mDemo2Fragment);
                break;
        }
        transaction.commit();
        return true;
    }

    private void loadFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mDemo1Fragment = new Demo1Fragment();
            mDemo2Fragment = new Demo2Fragment();
            mDemo3Fragment = new Demo3Fragment();
            mDemo4Fragment = new Demo4Fragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_main, mDemo1Fragment, mDemo1Fragment.getClass().getSimpleName())
                    .add(R.id.frame_main, mDemo2Fragment, mDemo2Fragment.getClass().getSimpleName())
                    .add(R.id.frame_main, mDemo3Fragment, mDemo3Fragment.getClass().getSimpleName())
                    .add(R.id.frame_main, mDemo4Fragment, mDemo4Fragment.getClass().getSimpleName())
                    .show(mDemo1Fragment)
                    .hide(mDemo2Fragment)
                    .hide(mDemo3Fragment)
                    .hide(mDemo4Fragment)
                    .commit();
        } else {
            mDemo1Fragment = (Demo1Fragment) getSupportFragmentManager()
                    .findFragmentByTag(Demo1Fragment.class.getSimpleName());
            mDemo2Fragment = (Demo2Fragment) getSupportFragmentManager()
                    .findFragmentByTag(Demo2Fragment.class.getSimpleName());
            mDemo3Fragment = (Demo3Fragment) getSupportFragmentManager()
                    .findFragmentByTag(Demo3Fragment.class.getSimpleName());
            mDemo4Fragment = (Demo4Fragment) getSupportFragmentManager()
                    .findFragmentByTag(Demo4Fragment.class.getSimpleName());
            getSupportFragmentManager().beginTransaction()
                    .show(mDemo1Fragment)
                    .hide(mDemo2Fragment)
                    .hide(mDemo3Fragment)
                    .hide(mDemo4Fragment)
                    .commit();
        }
    }
}
