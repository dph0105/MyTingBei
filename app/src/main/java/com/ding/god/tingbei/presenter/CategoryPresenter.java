package com.ding.god.tingbei.presenter;

import android.content.Context;
import android.util.Log;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.CategoryModel;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.ICategoryView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/5/4.
 */

public class CategoryPresenter extends BasePresenter<CategoryModel,ICategoryView> {

    public CategoryPresenter(Context context, ICategoryView mView) {
        super(context, mView);
        mModel = new CategoryModel();
    }

    public void initData(String category_id){
        mAPIService2.postRadioType(category_id,APPConstants.CUSTOMER_ID,APPConstants.DEVICE_ID)
                .compose(RxTransfromer.<BaseResponse<List<RadioTypeBean>>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<List<RadioTypeBean>>>() {
                    @Override
                    public void response(BaseResponse<List<RadioTypeBean>> response) {
                        mView.setAdapter(response.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }
}
