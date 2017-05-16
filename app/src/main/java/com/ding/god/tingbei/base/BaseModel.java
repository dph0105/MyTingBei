package com.ding.god.tingbei.base;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.gen.DaoSession;
import com.ding.god.tingbei.network.APIService;
import com.ding.god.tingbei.network.RetrofitClient;

/**
 * Created by god on 2017/4/6.
 */

public class BaseModel{
    protected APIService mAPiService;
    protected RetrofitClient mRetrofitClient;
    protected DaoSession daoSession;
    public BaseModel() {
        mAPiService = RetrofitClient.getAPIService();
        mRetrofitClient = RetrofitClient.getInstance();
        daoSession = MyApplication.getInstance().getDaoSession();
    }

}
