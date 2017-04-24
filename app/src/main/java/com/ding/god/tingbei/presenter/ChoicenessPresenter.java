package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.ChoicenessModel;
import com.ding.god.tingbei.model.bean.ChoicenessBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.IChoicenessView;

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
                .compose(RxTransfromer.<BaseResponse<ChoicenessBean>>observeOnToIO())
                .subscribe(new MConsumer<BaseResponse<ChoicenessBean>>() {
                    @Override
                    public void response(BaseResponse<ChoicenessBean> response) {
                        mModel.setData(response.getData());
                        mView.addData(response.getData());
                    }
                });
    }

}
