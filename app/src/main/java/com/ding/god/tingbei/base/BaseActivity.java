package com.ding.god.tingbei.base;


import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends RxAppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        initpresenter();
    }



    /**
     * 获得布局的id
     * @return 布局Id
     */
    protected abstract int getLayoutID();


    protected abstract void initpresenter();


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
        ButterKnife.bind(this).unbind();
    }
}
