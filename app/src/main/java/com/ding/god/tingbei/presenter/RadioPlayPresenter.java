package com.ding.god.tingbei.presenter;

import android.content.Context;
import android.provider.MediaStore;
import android.util.Log;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.RadioPlayModel;
import com.ding.god.tingbei.model.bean.RadioInfoBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;
import com.ding.god.tingbei.view.iview.IRadioPlayView;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/5/8.
 */

public class RadioPlayPresenter extends BasePresenter<RadioPlayModel,IRadioPlayView> {

    public RadioPlayPresenter(Context context, IRadioPlayView mView) {
        super(context, mView);
        mModel = new RadioPlayModel();
    }

    public void initData(String radio_id){
        mAPIService2.postRadioInfo(radio_id, APPConstants.CUSTOMER_ID,APPConstants.DEVICE_ID)
                .compose(RxTransfromer.<BaseResponse<RadioInfoBean>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<RadioInfoBean>>() {
                    @Override
                    public void response(BaseResponse<RadioInfoBean> response) {
                        mModel.setRadioInfoBean(response.getData());
                        mView.setView(response.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.toast("联网失败",0);
                    }
                });
    }

    public void playControl(){
        if(MyApplication.getInstance().getPlayState()==0) {
            PlayControlEvent.StartPlay startPlay = new PlayControlEvent.StartPlay();
            Log.d("stream","presenter:"+mModel.getRadioInfoBean().getLive_stream());
            startPlay.setRadioBean(mModel.getRadioInfoBean());
            RxBus.getRxBus().post(startPlay);
        }else if(MyApplication.getInstance().getPlayState()==1) {
            RxBus.getRxBus().post(new PlayControlEvent.StopPlay());
        }
    }

}
