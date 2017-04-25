package com.ding.god.tingbei.base;

import android.content.Context;

import com.ding.god.tingbei.network.APIService;
import com.ding.god.tingbei.network.RetrofitClient;

/**
 * Created by god on 2017/4/6.
 */

public abstract class BasePresenter<M extends BaseModel,V extends IBaseView> {

    protected Context context;
    protected APIService mAPiService;
    protected RetrofitClient mRetrofitClient;
    protected M mModel;
    protected V mView;

    public BasePresenter(Context context,V mView) {
        this.context = context;
        this.mView = mView;
        mAPiService = RetrofitClient.getAPIService();
        mRetrofitClient = RetrofitClient.getInstance();
    }

    public void init(){
        mView.initView();
        mView.initData();
        mView.bindListener();
    }

    public void onDestroy(){
        mView = null;
    }




}
