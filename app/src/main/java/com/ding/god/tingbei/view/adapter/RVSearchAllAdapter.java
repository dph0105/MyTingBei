package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.SearchResultAllBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by god on 2017/5/2.
 */

public class RVSearchAllAdapter extends BaseRVAdapter<SearchResultAllBean,RVSearchAllAdapter.SearchAllViewHolder> {
    public RVSearchAllAdapter(Context context) {
        super(context);
    }

    @Override
    public SearchAllViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_search_all, parent, false);
        return new SearchAllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchAllViewHolder holder, int position) {
        SearchResultAllBean data = getDatas().get(position);
        holder.tvSearchAllName.setText(data.getName());
        holder.tvSearchallStringContent.setText(data.getStringContent());
        RVSearchTypeAdatper adatper = new RVSearchTypeAdatper(mContext);
        holder.rvSearchAll.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvSearchAll.setAdapter(adatper);
        adatper.addAll(data.getList());
    }

    static class SearchAllViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_search_all_name)
        TextView tvSearchAllName;
        @BindView(R.id.rv_search_all)
        RecyclerView rvSearchAll;
        @BindView(R.id.tv_searchall_stringContent)
        TextView tvSearchallStringContent;

        SearchAllViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
