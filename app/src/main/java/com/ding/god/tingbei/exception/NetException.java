package com.ding.god.tingbei.exception;

/**
 * Created by god on 2017/4/11.
 */

public class NetException extends Exception {

    public NetException() {
    }

    public NetException(String message) {
        super(message);
    }

    public NetException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetException(Throwable cause) {
        super(cause);
    }
}
