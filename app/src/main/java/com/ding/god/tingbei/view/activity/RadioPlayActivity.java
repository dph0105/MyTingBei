package com.ding.god.tingbei.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseActivity;
import com.ding.god.tingbei.presenter.RadioPlayPresenter;
import com.ding.god.tingbei.view.iview.IRadioPlayView;

public class RadioPlayActivity extends BaseActivity<RadioPlayPresenter> implements IRadioPlayView{


    @Override
    protected int getLayoutID() {
        return R.layout.activity_radio_play;
    }

    @Override
    protected void initpresenter() {
        presenter = new RadioPlayPresenter(mContext,this);
        presenter.init();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void bindListener() {

    }
}
