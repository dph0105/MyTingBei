package com.ding.god.tingbei.rx;


import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by god on 2017/4/14.
 */

public class RxTransfromer {
    public static  <T> FlowableTransformer<T,T> observeOnToMain(){
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())   //被观察在子线程发送数据
                                .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static  <T> FlowableTransformer<T,T> observeOnToIO(){
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
