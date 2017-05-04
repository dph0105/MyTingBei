package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.CategoryDetailModel;
import com.ding.god.tingbei.model.bean.RadioByTypeBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.ICategoryDetailView;
import com.ding.god.tingbei.view.iview.ICategoryView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/5/4.
 */

public class CategoryDetailPresenter extends BasePresenter<CategoryDetailModel,ICategoryDetailView> {

    public CategoryDetailPresenter(Context context, ICategoryDetailView mView) {
        super(context, mView);
        mModel = new CategoryDetailModel();
    }

    public void initData(String category_id,String category_type,int page){
        mAPIService2.postRadioByType(category_id,category_type,page, APPConstants.CUSTOMER_ID,APPConstants.DEVICE_ID)
                .compose(RxTransfromer.<BaseResponse<List<RadioByTypeBean>>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<List<RadioByTypeBean>>>() {
                    @Override
                    public void response(BaseResponse<List<RadioByTypeBean>> response) {
                        mView.addData(response.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }
}
