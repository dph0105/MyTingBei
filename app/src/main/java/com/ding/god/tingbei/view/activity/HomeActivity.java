package com.ding.god.tingbei.view.activity;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ding.god.tingbei.base.BaseActivity;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.customview.PlayBar;
import com.ding.god.tingbei.presenter.MainPresenter;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.adapter.HomePagerAdapter;
import com.ding.god.tingbei.view.iview.IMainView;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.List;

import butterknife.BindView;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import static android.os.Build.VERSION_CODES.M;


public class HomeActivity extends PlayBarBaseActivity<MainPresenter> implements IMainView {


    @BindView(R.id.iv_search_activity_home)
    ImageView ivSearchActivityHome;
    @BindView(R.id.tablayout_activity_home)
    TabLayout tablayoutActivityHome;
    @BindView(R.id.rl_activity_main_topbar)
    RelativeLayout rlActivityMainTopbar;
    @BindView(R.id.vp_activity_home)
    ViewPager vpActivityHome;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initpresenter() {
        presenter = new MainPresenter(this, this);
        presenter.init();
    }

    @Override
    public void initView() {
        presenter.setAdapter();
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindListener() {
        ivSearchActivityHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setVPAdapter(List<BaseFragment> fragments, String[] tabTitle) {
        //初始化ViewPager的适配器
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(this, getSupportFragmentManager(), fragments, tabTitle);
        vpActivityHome.setAdapter(homePagerAdapter);
        //TabLayout绑定ViewPager
        tablayoutActivityHome.setupWithViewPager(vpActivityHome);
        vpActivityHome.setOffscreenPageLimit(3);
    }



}
