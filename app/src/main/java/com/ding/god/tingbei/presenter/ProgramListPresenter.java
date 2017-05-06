package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.ProgramListModel;
import com.ding.god.tingbei.model.bean.ProgramListBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.IProgramListView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static android.R.attr.order;

/**
 * Created by Administrator on 2017/5/6.
 */

public class ProgramListPresenter extends BasePresenter<ProgramListModel,IProgramListView> {
    public ProgramListPresenter(Context context, IProgramListView mView) {
        super(context, mView);
        mModel = new ProgramListModel();
    }

    public void initData(String program_id,String program_type,String program_list_id,int page,int order){
        mAPIService2.postProgramList(program_id,program_type,program_list_id,page,order, APPConstants.CUSTOMER_ID,APPConstants.DEVICE_ID)
                .compose(RxTransfromer.<BaseResponse<List<ProgramListBean>>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<List<ProgramListBean>>>() {
                    @Override
                    public void response(BaseResponse<List<ProgramListBean>> response) {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });

    }
}
