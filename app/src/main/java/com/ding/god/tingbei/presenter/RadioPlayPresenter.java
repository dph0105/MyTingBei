package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.RadioPlayModel;
import com.ding.god.tingbei.view.iview.IRadioPlayView;

/**
 * Created by Administrator on 2017/5/8.
 */

public class RadioPlayPresenter extends BasePresenter<RadioPlayModel,IRadioPlayView> {

    public RadioPlayPresenter(Context context, IRadioPlayView mView) {
        super(context, mView);
        mModel = new RadioPlayModel();
    }
}
