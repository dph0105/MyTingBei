package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.ProgramPlayModel;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;
import com.ding.god.tingbei.service.PlayService;
import com.ding.god.tingbei.model.bean.ProgramInfoBean;
import com.ding.god.tingbei.view.iview.IProgramPlayView;

/**
 * Created by Administrator on 2017/5/12.
 */

public class ProgramPlayPresenter extends BasePresenter<ProgramPlayModel,IProgramPlayView> {
    public ProgramPlayPresenter(Context context, IProgramPlayView mView) {
        super(context, mView);
        mModel = new ProgramPlayModel();
    }
    public void initData(String program_id,String program_type,String customer_id){
        mAPIService2.postProgramInfo(program_id,program_type,customer_id)
                .compose(RxTransfromer.<BaseResponse<ProgramInfoBean>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<ProgramInfoBean>>() {
                    @Override
                    public void response(BaseResponse<ProgramInfoBean> response) {
                        mView.setView(response.getData());
                        mModel.setProgramInfoBean(response.getData());
                        PlayControlEvent.StartPlayRefresh startPlayRefresh = new PlayControlEvent.StartPlayRefresh();
                        startPlayRefresh.setProgramInfoBean(response.getData());
                        RxBus.getRxBus().post(startPlayRefresh);
                    }
                });
    }

    public void playControl(){
        if(PlayService.getPlayState()==PlayService.PLAYSTATE_NULL||PlayService.getPlayState()==PlayService.PLAYSTATE_PAUSE) {
            PlayControlEvent.StartPlay startPlay = new PlayControlEvent.StartPlay();
            startPlay.setProgramInfoBean(mModel.getProgramInfoBean());
            RxBus.getRxBus().post(startPlay);
        }else if(PlayService.getPlayState()==PlayService.PLAYSTATE_PLAYING) {
            RxBus.getRxBus().post(new PlayControlEvent.StopPlay());
        }
    }
}
