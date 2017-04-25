package com.ding.god.tingbei.network;

import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.model.bean.RadioCategoryBean;
import com.ding.god.tingbei.model.bean.RadioGroupBean;
import com.ding.god.tingbei.model.bean.RadioTypeBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by god on 2017/4/5.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("first-page/get-first-page")
    Flowable<BaseResponse<ChoicenessBean>> postChoiceness(@Field("area_id") String area_id);//精选页面的数据

    @GET("radio/getRadioCategory")
    Flowable<BaseResponse<RadioCategoryBean>> getRadioCategory();                           //电台页面分类的数据

    @FormUrlEncoded
    @POST("radio/get-radio-group")
    Flowable<BaseResponse<RadioGroupBean>> postRadioGroup(@Field("area_id") String area_id);//电台页面分组的数据

    @FormUrlEncoded
    @POST("program/getRadioType")
    Flowable<BaseResponse<RadioTypeBean>> postRadioType(@Field("customerID") String customerID,
                                                        @Field("device_id") String device_id);
}
