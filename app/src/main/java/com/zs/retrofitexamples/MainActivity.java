package com.zs.retrofitexamples;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zs.retrofitexamples.base.BaseActivity;
import com.zs.retrofitexamples.base.BaseViewPagerAdapter;
import com.zs.retrofitexamples.core.GlobalConfig;
import com.zs.retrofitexamples.module.operators.OperatorsFragment;
import com.zs.retrofitexamples.util.ScreenUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.home_appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.home_viewPager)
    ViewPager mViewPager;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.fab)
    FloatingActionButton mFab;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
//        StatusBarUtil.setTranslucent(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // 4.4 以上版本
            // 设置 Toolbar 高度为 80dp，适配状态栏
            ViewGroup.LayoutParams layoutParams = mToolbarTitle.getLayoutParams();
//            layoutParams.height = ScreenUtil.dip2px(this,ScreenUtil.getStatusBarHeight(this));
            layoutParams.height = ScreenUtil.dip2px(this,80);
            mToolbarTitle.setLayoutParams(layoutParams);
        }

        initToolBar(mToolbar, false, "");
        String []titles = {
                GlobalConfig.CATEGORY_NAME_OPERATORS,
                GlobalConfig.CATEGORY_NAME_EXAMPLES
        };

        BaseViewPagerAdapter pagerAdapter = new BaseViewPagerAdapter(getSupportFragmentManager(),titles);
        pagerAdapter.addFragment(new OperatorsFragment());

        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /** 初始化 Toolbar */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }


    @OnClick(R.id.fab)
    public void onViewClicked() {
    }

    @Override
    protected boolean translucentStatusBar() {
        return true;
    }
}
