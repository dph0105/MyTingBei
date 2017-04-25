package com.ding.god.tingbei.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by god on 2017/4/23.
 */

public class CustomRV extends RecyclerView {
    public CustomRV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRV(Context context) {
        super(context);
    }

    public CustomRV(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightSpec);
    }
}
