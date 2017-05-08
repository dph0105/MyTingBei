package com.ding.god.tingbei.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.PlayBarBaseActivity;
import com.ding.god.tingbei.model.bean.AlbumInfoBean;
import com.ding.god.tingbei.presenter.AlbumPresenter;
import com.ding.god.tingbei.view.adapter.VPAlbumAdapter;
import com.ding.god.tingbei.view.iview.IAlbumView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumActivity extends PlayBarBaseActivity<AlbumPresenter> implements IAlbumView {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_Album_top_title)
    TextView tvAlbumTopTitle;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.iv_album_logo)
    ImageView ivAlbumLogo;
    @BindView(R.id.tv_album_name)
    TextView tvAlbumName;
    @BindView(R.id.tv_album_host)
    TextView tvAlbumHost;
    @BindView(R.id.tv_album_category_tip)
    TextView tvAlbumCategoryTip;
    @BindView(R.id.center)
    View center;
    @BindView(R.id.rl_collect)
    RelativeLayout rlCollect;
    @BindView(R.id.rl_download)
    RelativeLayout rlDownload;
    @BindView(R.id.tl_activity_album)
    TabLayout tlActivityAlbum;
    @BindView(R.id.vp_activity_album)
    ViewPager vpActivityAlbum;
    @BindView(R.id.activity_album)
    CoordinatorLayout activityAlbum;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_album;
    }

    @Override
    protected void initpresenter() {
        presenter = new AlbumPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {


    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String album_id = intent.getStringExtra("album_id");
        String album_type = intent.getStringExtra("album_type");
        presenter.initData(album_id, album_type, "");
        presenter.setVPAdapter();
    }

    @Override
    public void bindListener() {

    }

    @Override
    public void initAlbumInfo(AlbumInfoBean data) {
        mImageUtil.loadURLImage(data.getAlbum_logo(),ivAlbumLogo);
        tvAlbumName.setText(data.getAlbum_name());
        tvAlbumHost.setText("主播:"+data.getAlbum_host()==""?"暂无":data.getAlbum_name());
        tvAlbumCategoryTip.setText("分类:"+data.getCategory_tip());
    }

    @Override
    public void setVPAdapter(List<BaseFragment> fragments, String[] tabTitle) {
        VPAlbumAdapter adapter = new VPAlbumAdapter(getSupportFragmentManager(),fragments,tabTitle);
        vpActivityAlbum.setAdapter(adapter);
        tlActivityAlbum.setupWithViewPager(vpActivityAlbum);
    }


}
