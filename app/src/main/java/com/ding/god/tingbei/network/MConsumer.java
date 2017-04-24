package com.ding.god.tingbei.network;

import com.ding.god.tingbei.exception.NetException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by god on 2017/4/11.
 */

public abstract class MConsumer<T extends BaseResponse> implements Consumer<T> {

    public abstract void response(T response);

    @Override
    public void accept(@NonNull T t) throws Exception {
        int code = t.getCode();
        String message = t.getMessage();
        if (code==0){
            response(t);
        }else {
            throw new NetException(message);
        }
    }


}
