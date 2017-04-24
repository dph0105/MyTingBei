package com.ding.god.tingbei;

import android.app.Application;

/**
 * Created by god on 2017/4/13.
 */

public class APP extends Application {

    private APP app;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;
    }

    public APP getApp() {
        return app;
    }
}
