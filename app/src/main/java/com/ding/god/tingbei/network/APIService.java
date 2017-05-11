package com.ding.god.tingbei.network;

import com.ding.god.tingbei.model.bean.AlbumInfoBean;
import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.model.bean.LoadingImgBean;
import com.ding.god.tingbei.model.bean.LocalRadioBean;
import com.ding.god.tingbei.model.bean.ProgramListBean;
import com.ding.god.tingbei.model.bean.RadioArea;
import com.ding.god.tingbei.model.bean.RadioBean;
import com.ding.god.tingbei.model.bean.RadioByTypeBean;
import com.ding.god.tingbei.model.bean.RadioCategoryBean;
import com.ding.god.tingbei.model.bean.RadioGroupBean;
import com.ding.god.tingbei.model.bean.RadioInfoBean;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.model.bean.SearchResultAllBean;
import com.ding.god.tingbei.model.bean.SearchResultTypeBean;

import java.util.List;

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
    @POST("inter/getLoadingImg")
    Flowable<LoadingImgBean> postLoadingImg();//广告页面的图片  2

    @FormUrlEncoded
    @POST("first-page/get-first-page")
    Flowable<BaseResponse<ChoicenessBean>> postChoiceness(@Field("area_id") String area_id);//精选页面的数据 2

    @GET("radio/getRadioCategory")
    Flowable<BaseResponse<RadioCategoryBean>> getRadioCategory();                           //电台页面分类的数据 1

    @FormUrlEncoded
    @POST("radio/get-radio-group")
    Flowable<BaseResponse<RadioGroupBean>> postRadioGroup(@Field("area_id") String area_id);//电台页面分组的数据

    @FormUrlEncoded
    @POST("program/getRadioType")
    Flowable<BaseResponse<List<RadioTypeBean>>> postRadioType(@Field("customerID") String customerID,   // 分类页面 所有分类  2
                                                             @Field("device_id") String device_id);


    @FormUrlEncoded
    @POST("program/getRadioType")
    Flowable<BaseResponse<List<RadioTypeBean>>> postRadioType(@Field("category_id") String category_id,  //分类中某一大类的分类 2
                                                              @Field("customerID") String customerID,
                                                              @Field("device_id") String device_id);

    @FormUrlEncoded
    @POST("program/getRadioByType557")
    Flowable<BaseResponse<List<RadioByTypeBean>>> postRadioByType(@Field("category_id") String category_id,  //分类的分类的具体 2
                                                                  @Field("category_type") String category_type,   //all 或者 sub
                                                                  @Field("page") int page,
                                                                  @Field("customerID") String customerID,
                                                                  @Field("device_id") String device_id);


    @FormUrlEncoded
    @POST("radio/getRadioInfo552")
    Flowable<BaseResponse<LocalRadioBean>> postLocalRadioInfo(@Field("customer_area_id") String customer_area_id,   // 电台页面的浙江以及本地电台的更多  2
                                                              @Field("page") int page);
    @FormUrlEncoded
    @POST("radio/getRadioInfo552")
    Flowable<BaseResponse<LocalRadioBean>> postLocalRadioInfo(@Field("page") int page);  // 全国电台  2

    @FormUrlEncoded
    @POST("radio/getRadioByCategory")
    Flowable<BaseResponse<List<RadioBean>>> postRadioCategory(@Field("category_id") String category_id,   // 电台页面的国家或者网络台,以及电台分类的点击  2
                                                              @Field("page") int page);

    @GET("radio/getRadioAreaList")
    Flowable<BaseResponse<List<RadioArea>>> getRadioArea();                                               //电台页面的省市台  2

    @FormUrlEncoded
    @POST("search/getSearchList")
    Flowable<BaseResponse<List<SearchResultAllBean>>> postSearchList(@Field("searchName") String searchName,  //搜索的名字 2
                                                               @Field("type") int type,   //根据4个标签,0,1,2,3
                                                               @Field("page") int page,
                                                               @Field("page_size") int page_size); //写默认10

    @FormUrlEncoded
    @POST("search/getSearchList")
    Flowable<BaseResponse<List<SearchResultTypeBean>>> postSearchTypeList(@Field("searchName") String searchName,  //搜索的名字 2
                                                                          @Field("type") int type,   //根据4个标签,1,2,3
                                                                          @Field("page") int page,
                                                                          @Field("page_size") int page_size); //写默认10


    @FormUrlEncoded
    @POST("album/getAlbumInfo")
    Flowable<BaseResponse<AlbumInfoBean>> postAlbumInfo(@Field("album_id") String album_id,         //专辑详情的专辑信息
                                                        @Field("album_type") String album_type,
                                                        @Field("program_id") String program_id);  //???暂时没有填

    @FormUrlEncoded
    @POST("program/getOverProgram")
    Flowable<BaseResponse<List<ProgramListBean>>> postProgramList(@Field("program_id") String program_id, //""         //专辑详情的节目列表 2
                                                                  @Field("program_type") String program_type,   //
                                                                  @Field("program_list_id") String program_list_id,
                                                                  @Field("page") int page,
                                                                  @Field("order") int order,    //默认  1
                                                                  @Field("customerID") String customerID,
                                                                  @Field("device_id") String device_id);


    @FormUrlEncoded
    @POST("live/getRadioInfo")
    Flowable<BaseResponse<RadioInfoBean>> postRadioInfo(@Field("radio_id") String radio_id,         //电台播放页信息
                                                        @Field("customer_id") String customer_id,  //kong
                                                        @Field("equipment_id") String equipment_id);

    @FormUrlEncoded
    @POST("programComment/getProgramCommentListByAlbumId")
    Flowable<BaseResponse<AlbumInfoBean>> postProgramComment(@Field("page") int page,         //pinglun
                                                        @Field("radio_id") String radio_id,  //kong
                                                        @Field("album_id") String album_id,
                                                        @Field("page_size") int page_size);



}
