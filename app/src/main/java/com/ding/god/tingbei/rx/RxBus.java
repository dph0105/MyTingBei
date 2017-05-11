package com.ding.god.tingbei.rx;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.processors.ReplayProcessor;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

/**
 * Created by god on 2017/4/13.
 */

public class RxBus {
   private final FlowableProcessor<Object> rxBus;


    private final Map<Class<?>, Object> mStickyEventMap;


    private RxBus() {
        rxBus = PublishProcessor.create().toSerialized();
        mStickyEventMap = new ConcurrentHashMap<>(); //ConcurrentHashMap是一个线程安全的HashMap， 采用stripping lock（分离锁），效率比HashTable高很多。
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

    public <T> Flowable<T> toFlowableSticky(final Class<T> eventType) {
        synchronized (mStickyEventMap) {
            Flowable<T> flowable = rxBus.ofType(eventType);
            final Object event = mStickyEventMap.get(eventType);
            if (event != null) {
                return flowable.mergeWith(Flowable.create(new FlowableOnSubscribe<T>() {
                    @Override
                    public void subscribe(@NonNull FlowableEmitter<T> e) throws Exception {
                        e.onNext(eventType.cast(event));
                    }
                }, BackpressureStrategy.BUFFER));
            } else {
                return flowable;
            }
        }
    }


    public void post(Object o){
        rxBus.onNext(o);
    }

    /**
     * 发送一个新Sticky事件
     */
    public void postSticky(Object event) {
        synchronized (mStickyEventMap) {
            mStickyEventMap.put(event.getClass(), event);
        }
        post(event);
    }


    /**
     * 移除所有的Sticky事件
     */
    public void removeAllStickyEvents() {
        synchronized (mStickyEventMap) {
            mStickyEventMap.clear();
        }
    }

}
