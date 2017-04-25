package com.ding.god.tingbei.util;

import android.content.Context;

/**
 * Created by Administrator on 2017/4/25.
 */

public class DensityUtil {
    public static int dp2px(Context context,int dp){
        float density = context.getResources().getDisplayMetrics().density;
        return ((int) (dp * density + 0.5f));
    }
}
