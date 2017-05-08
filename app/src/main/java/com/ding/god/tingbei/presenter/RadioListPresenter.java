package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.RadioListModel;
import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.model.bean.LocalRadioBean;
import com.ding.god.tingbei.model.bean.RadioBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.IRadioListView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/5/8.
 */

public class RadioListPresenter extends BasePresenter<RadioListModel,IRadioListView> {
    public RadioListPresenter(Context context, IRadioListView mView) {
        super(context, mView);
        mModel= new RadioListModel();
    }

    public void initData(String category_id,int page,int localOrCountry){
        switch (localOrCountry){
            case 0:
                mAPIService2.postRadioCategory(category_id,page)
                        .compose(RxTransfromer.<BaseResponse<List<RadioBean>>>observeOnToMain())
                        .subscribe(new MConsumer<BaseResponse<List<RadioBean>>>() {
                            @Override
                            public void response(BaseResponse<List<RadioBean>> response) {
                                mView.addData(response.getData());
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {

                            }
                        });
                break;
            case 1://本地电台
                mAPIService2.postLocalRadioInfo(APPConstants.AREA_ID,page)
                        .compose(RxTransfromer.<BaseResponse<LocalRadioBean>>observeOnToMain())
                        .subscribe(new MConsumer<BaseResponse<LocalRadioBean>>() {
                            @Override
                            public void response(BaseResponse<LocalRadioBean> response) {
                                mView.addData(response.getData().getLocal().getData());
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {

                            }
                        });
                break;
            case 2:// 全国电台
                mAPIService2.postLocalRadioInfo(page)
                        .compose(RxTransfromer.<BaseResponse<LocalRadioBean>>observeOnToMain())
                        .subscribe(new MConsumer<BaseResponse<LocalRadioBean>>() {
                            @Override
                            public void response(BaseResponse<LocalRadioBean> response) {
                                mView.addData(response.getData().getAll().getData());
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {

                            }
                        });
        }
    }
}
