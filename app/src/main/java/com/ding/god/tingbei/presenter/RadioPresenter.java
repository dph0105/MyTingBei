package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.RadioModel;
import com.ding.god.tingbei.view.iview.IRadioView;

/**
 * Created by god on 2017/4/25.
 */

public class RadioPresenter extends BasePresenter<RadioModel,IRadioView> {
    public RadioPresenter(Context context, IRadioView mView) {
        super(context, mView);
        mModel = new RadioModel();
    }
}
