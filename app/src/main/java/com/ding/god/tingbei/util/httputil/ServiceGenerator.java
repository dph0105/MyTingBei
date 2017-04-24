package com.ding.god.tingbei.util.httputil;

import com.ding.god.tingbei.network.APIService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by god on 2017/4/5.
 */

public class ServiceGenerator {
    //基础接口
    public static final String API_BASE_URL = "http://apinew2.tinberfm.cn/index.php/";

    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient())
            .build();

    private APIService mAPIService = retrofit.create(APIService.class);


}
