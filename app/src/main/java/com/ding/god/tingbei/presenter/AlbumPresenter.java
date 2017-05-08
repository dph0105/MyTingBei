package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.APPConstants;
import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.AlbumModel;
import com.ding.god.tingbei.model.bean.AlbumInfoBean;
import com.ding.god.tingbei.model.bean.ProgramListBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.IAlbumView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/5/6.
 */

public class AlbumPresenter extends BasePresenter<AlbumModel,IAlbumView> {
    public AlbumPresenter(Context context, IAlbumView mView) {
        super(context, mView);
        mModel = new AlbumModel();
    }

    public void initData(final String album_id, final String album_type, final String program_id){
        mModel.setData(album_id,album_type,program_id);
        mAPIService2.postAlbumInfo(album_id,album_type,program_id)
                .compose(RxTransfromer.<BaseResponse<AlbumInfoBean>>observeOnToMain())
                .subscribe(new MConsumer<BaseResponse<AlbumInfoBean>>() {
                    @Override
                    public void response(BaseResponse<AlbumInfoBean> response) {
                        mView.initAlbumInfo(response.getData());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });

    }

    public void setVPAdapter(){
        mView.setVPAdapter(mModel.getFragments(),mModel.getTabTitle());
    }
}
