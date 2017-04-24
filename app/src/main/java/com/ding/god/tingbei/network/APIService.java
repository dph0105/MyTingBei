package com.ding.god.tingbei.network;

import com.ding.god.tingbei.model.bean.ChoicenessBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by god on 2017/4/5.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("first-page/get-first-page")
    Flowable<BaseResponse<ChoicenessBean>> postChoiceness(@Field("area_id") String area_id);
}
