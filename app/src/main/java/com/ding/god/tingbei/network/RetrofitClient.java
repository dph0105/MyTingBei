package com.ding.god.tingbei.network;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by god on 2017/4/6.
 */

public class RetrofitClient {
    //基础接口
    private static final String API_BASE_URL = "http://apinew2.tinberfm.cn/index.php/";       //1
    private static final String API_BASE_OLD_URL = "http://apinew.tinberfm.com/interface/";  //2

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(new OkHttpClient())
            .build();

    private Retrofit retrofit2 = new Retrofit.Builder()
            .baseUrl(API_BASE_OLD_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(new OkHttpClient())
            .build();

    private APIService mAPIService = retrofit.create(APIService.class);
    private APIService mAPIService2 = retrofit2.create(APIService.class);

    private static class SingleRetrofit{
        private static final RetrofitClient SINGLEINSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance(){
        return SingleRetrofit.SINGLEINSTANCE;
    }

    public static APIService getAPIService(){
        return SingleRetrofit.SINGLEINSTANCE.mAPIService;
    }

    public static APIService getAPIService2(){
        return SingleRetrofit.SINGLEINSTANCE.mAPIService2;
    }

    public <T extends BaseResponse> void toSubscribe(Flowable<T> f, MConsumer<T> c){
        f.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(c);
    }

}
