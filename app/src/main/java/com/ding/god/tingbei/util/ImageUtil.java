package com.ding.god.tingbei.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by god on 2017/4/13.
 */

public  class ImageUtil {

    private Context context;

    public ImageUtil(Context context){
        this.context = context;
    }




    public void loadBlurBitmap(String url, final int radius, final ImageView imageView){
        Glide.with(context)
                .load(url)
                .bitmapTransform(new BlurTransformation(context,radius,1))
                .into(imageView);
    }

    public void loadURLImage(String url, ImageView imageView){
          Glide.with(context)
                  .load(url)
                  .into(imageView);
    }

}
