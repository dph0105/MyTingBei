package com.ding.god.tingbei.base;


import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public abstract class BaseActivity<P extends BasePresenter> extends RxAppCompatActivity implements IBaseView {

    protected P presenter;
    protected Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        mContext = this;
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

    @Override
    public void toast(String message, int time) {
        if(message!=null&&message.length()!=0) {
            if(time==0) {
                Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(mContext,message,time);
            }
        }
    }
}
