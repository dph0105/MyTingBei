package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.RadioModel;
import com.ding.god.tingbei.model.bean.RadioCategoryBean;
import com.ding.god.tingbei.model.bean.RadioGroupBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.network.RetrofitClient;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.IRadioView;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by god on 2017/4/25.
 */

public class RadioPresenter extends BasePresenter<RadioModel,IRadioView> {
    public RadioPresenter(Context context, IRadioView mView) {
        super(context, mView);
        mModel = new RadioModel();
    }

    public void initData() {
        mAPIService2.getRadioCategory()
                .compose(RxTransfromer.<BaseResponse<RadioCategoryBean>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<RadioCategoryBean>>() {
                    @Override
                    public void response(BaseResponse<RadioCategoryBean> response) {
                        mView.clear();
                        mView.addCategoryData(response.getData().getStyle());
                        mView.refreshComplete();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.toast("联网失败",0);
                        mView.refreshComplete();
                    }
                });
        mAPiService.postRadioGroup(APPConstants.AREA_ID)
                .compose(RxTransfromer.<BaseResponse<RadioGroupBean>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<RadioGroupBean>>() {
                    @Override
                    public void response(BaseResponse<RadioGroupBean> response) {
                        mView.addRadioGroupData(response.getData());
                        mView.refreshComplete();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.toast("联网失败",0);
                        mView.refreshComplete();
                    }
                });

    }

    public void refresh() {
        initData();
    }
}
