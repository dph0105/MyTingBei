package com.ding.god.tingbei.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.model.bean.ProgramListBean;
import com.ding.god.tingbei.presenter.ProgramListPresenter;
import com.ding.god.tingbei.service.PlayService;
import com.ding.god.tingbei.util.cacheutil.SPUtil;
import com.ding.god.tingbei.view.adapter.RVProgramListAdapter;
import com.ding.god.tingbei.view.iview.IProgramListView;

import java.util.List;

import butterknife.BindView;

import static com.ding.god.tingbei.service.PlayService.playType;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramListFragment extends BaseFragment<ProgramListPresenter> implements IProgramListView {


    @BindView(R.id.tv_program_total)
    TextView tvProgramTotal;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_albumset)
    TextView tvAlbumset;
    @BindView(R.id.rv_fragment_program_list)
    RecyclerView rvFragmentProgramList;
    private RVProgramListAdapter adapter;

    public ProgramListFragment() {
        // Required empty public constructor
    }

    public static ProgramListFragment newInstance() {
        Bundle args = new Bundle();
        ProgramListFragment fragment = new ProgramListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_program_list;
    }

    @Override
    protected void initPresenter() {
        presenter = new ProgramListPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {
        Log.d("fragment","ProgramList");
        rvFragmentProgramList.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new RVProgramListAdapter(mContext);
        rvFragmentProgramList.setAdapter(adapter);
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        String program_list_id = bundle.getString("album_id");
        String program_type = bundle.getString("album_type");
        String program_id = bundle.getString("program_id");
        presenter.initData(program_id ,program_type, program_list_id, 1, 1);

    }

    @Override
    public void bindListener() {

    }


    @Override
    public void addData(List<ProgramListBean> datas) {
        adapter.addAll(datas);
    }
}
