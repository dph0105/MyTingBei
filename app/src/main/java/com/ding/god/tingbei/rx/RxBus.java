package com.ding.god.tingbei.rx;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by god on 2017/4/13.
 */

public class RxBus {
   private final FlowableProcessor<Object> rxBus;

    private RxBus() {
        rxBus = PublishProcessor.create().toSerialized();

    }

    private static class Single{
        private static final RxBus INSTANCE = new RxBus();
    }

    public static RxBus getRxBus(){
        return Single.INSTANCE;
    }


    /**
     * 根据传入的类型返回特定的被观察者
     * @param eventType 类型
     * @param <T>
     * @return
     */
    public <T> Flowable<T> toFlowable(Class<T> eventType){
        return rxBus.ofType(eventType);
    }

}
