package com.ding.god.tingbei.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by god on 2017/4/13.
 */

public class ImageUtil {

    private Context context;

    public ImageUtil(Context context){
        this.context = context;
    }


    public void loadURLImage(String url, ImageView imageView){
          Picasso.with(context)
                  .load(url)
                  .into(imageView);
    }

}
