package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.MineModel;

/**
 * Created by Administrator on 2017/4/27.
 */

public class MinePresenter extends BasePresenter<MineModel,IBaseView> {

    public MinePresenter(Context context, IBaseView mView) {
        super(context, mView);
        mModel = new MineModel();
    }
}
