package com.ding.god.tingbei.presenter;

import android.content.Context;

import com.ding.god.tingbei.base.BasePresenter;
import com.ding.god.tingbei.model.SearchResultListModel;
import com.ding.god.tingbei.model.bean.SearchResultAllBean;
import com.ding.god.tingbei.model.bean.SearchResultTypeBean;
import com.ding.god.tingbei.network.BaseResponse;
import com.ding.god.tingbei.network.MConsumer;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.view.iview.ISearchResultListView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by god on 2017/5/2.
 */

public class SearchResultListPresenter extends BasePresenter<SearchResultListModel,ISearchResultListView> {
    public SearchResultListPresenter(Context context, ISearchResultListView mView) {
        super(context, mView);
    }

    public void initData(String searchName,int type){
        if (type==0){
            mAPIService2.postSearchList(searchName,type,1,10)
                    .compose(RxTransfromer.<BaseResponse<List<SearchResultAllBean>>>observeOnToMain())
                    .subscribe(new MConsumer<BaseResponse<List<SearchResultAllBean>>>() {
                        @Override
                        public void response(BaseResponse<List<SearchResultAllBean>> response) {
                            mView.addData(response.getData());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(@NonNull Throwable throwable) throws Exception {

                        }
                    });
        }else {
            mAPIService2.postSearchTypeList(searchName,type,1,10)
                    .compose(RxTransfromer.<BaseResponse<List<SearchResultTypeBean>>>observeOnToMain())
                    .subscribe(new MConsumer<BaseResponse<List<SearchResultTypeBean>>>() {
                        @Override
                        public void response(BaseResponse<List<SearchResultTypeBean>> response) {
                            mView.addTypeData(response.getData());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(@NonNull Throwable throwable) throws Exception {

                        }
                    });
        }
    }
}
