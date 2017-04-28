package com.ding.god.tingbei.presenter;


import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.MainModel;
import com.ding.god.tingbei.view.iview.IMainView;

/**
 * Created by god on 2017/4/6.
 */

public class MainPresenter extends BasePresenter<MainModel,IMainView> {


    public MainPresenter(Context context, IMainView mView) {
        super(context, mView);
        mModel = new MainModel();
    }



    public void setAdapter(){
        mView.setVPAdapter(mModel.getFragments(),mModel.getTabTitle());
    }







}
