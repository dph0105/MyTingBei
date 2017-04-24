package com.ding.god.tingbei.base;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;


public abstract class BaseFragment<P extends BasePresenter> extends RxFragment{

    protected P presenter;
    protected Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        ButterKnife.bind(this,view);
        mContext = getContext();
        initPresenter();
        return view;
    }


    /**
     * 获得布局的id
     * @return 布局Id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化Presenter
     */
    protected abstract void initPresenter();




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.bind(getActivity()).unbind();
    }
}
