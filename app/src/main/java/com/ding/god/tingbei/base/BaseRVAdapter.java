package com.ding.god.tingbei.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.ding.god.tingbei.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by god on 2017/4/11.
 */

public abstract class BaseRVAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> datas;
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected ImageUtil mImageUtil;
    public BaseRVAdapter(Context context) {
        datas = new ArrayList<>();
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        mImageUtil = new ImageUtil(context);
    }

    @Override
    public int getItemCount() {
        if (datas!=null){
            return datas.size();
        }
        return 0;
    }

    public void clearAll(){
        datas.clear();
    }

    public void addAll(List<T> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void add(T data){
        this.datas.add(data);
        notifyDataSetChanged();
    }

    public List<T> getDatas(){
        return datas;
    }

}
