package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.ChoicenessModel;
import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.IChoicenessView;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by god on 2017/4/11.
 */

public class ChoicenessPresenter extends BasePresenter<ChoicenessModel,IChoicenessView> {

    public ChoicenessPresenter(Context context, IChoicenessView mView) {
        super(context, mView);
        mModel = new ChoicenessModel();
    }
    public void initData() {
        mAPiService.postChoiceness(APPConstants.AREA_ID)
                .compose(RxTransfromer.<BaseResponse<ChoicenessBean>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<ChoicenessBean>>() {
                    @Override
                    public void response(BaseResponse<ChoicenessBean> response) {
                        mModel.setData(response.getData());
                        mView.clearData();
                        mView.addData(response.getData());
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

    public void refresh(){

        initData();
    }



}
