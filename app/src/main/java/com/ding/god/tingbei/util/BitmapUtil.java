package com.ding.god.tingbei.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;

/**
 * Created by Administrator on 2017/5/12.
 */

public class BitmapUtil {

    //模糊图片
    public Bitmap blurBitmap(Context context, Bitmap bitmap,float radius){

        //Create renderscript

        RenderScript rs = RenderScript.create(context);



        //Create allocation from Bitmap

        Allocation allocation = Allocation.createFromBitmap(rs, bitmap);



        Type t = allocation.getType();



        //Create allocation with the same type

        Allocation blurredAllocation = Allocation.createTyped(rs, t);



        //Create script

        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

        //Set blur radius (maximum 25.0)

        blurScript.setRadius(radius);

        //Set input for script

        blurScript.setInput(allocation);

        //Call script for output allocation

        blurScript.forEach(blurredAllocation);



        //Copy script result into bitmap

        blurredAllocation.copyTo(bitmap);



        //Destroy everything to free memory

        allocation.destroy();

        blurredAllocation.destroy();

        blurScript.destroy();

        t.destroy();

        rs.destroy();

        return bitmap;


    }

}
