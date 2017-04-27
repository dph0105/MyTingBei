package com.ding.god.tingbei.base;

import android.support.annotation.Nullable;

/**
 * Created by god on 2017/4/6.
 */

public interface IBaseView {
    void initView();
    void initData();
    void bindListener();
    void toast(String message, int time);
}
