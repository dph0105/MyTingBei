package com.ding.god.tingbei.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseRVAdapter;
import com.ding.god.tingbei.model.bean.ProgramListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/8.
 */

public class RVProgramListAdapter extends BaseRVAdapter<ProgramListBean,RVProgramListAdapter.ProgramListViewHolder> {

    public RVProgramListAdapter(Context context) {
        super(context);
    }

    @Override
    public ProgramListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_program_list, parent, false);
        return new ProgramListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramListViewHolder holder, int position) {
        holder.tvProgramName.setText(getDatas().get(position).getProgram_name());
        holder.tvProgramName.setText(getDatas().get(position).getProgram_date()+" 更新");
    }

    static class ProgramListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_program_name)
        TextView tvProgramName;
        @BindView(R.id.tv_program_updata_date)
        TextView tvProgramUpdataDate;

        ProgramListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
