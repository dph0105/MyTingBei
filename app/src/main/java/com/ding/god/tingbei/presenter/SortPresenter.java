package com.ding.god.tingbei.presenter;

import android.content.Context;
import android.widget.Toast;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.SortModel;
import com.ding.god.tingbei.model.bean.RadioTypeBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.ISortView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/4/27.
 */

public class SortPresenter extends BasePresenter<SortModel,ISortView> {

    public SortPresenter(Context context, ISortView mView) {
        super(context, mView);
        mModel = new SortModel();
    }

    public void initData(){
        mAPIService2.postRadioType(APPConstants.CUSTOMER_ID,APPConstants.DEVICE_ID)
                .compose(RxTransfromer.<BaseResponse<List<RadioTypeBean>>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<List<RadioTypeBean>>>() {
                    @Override
                    public void response(BaseResponse<List<RadioTypeBean>> response) {
                        mView.clear();
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
    public void refresh() {
        initData();
    }
}
