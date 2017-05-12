package com.ding.god.tingbei.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseActivity;
import com.ding.god.tingbei.model.bean.ProgramInfoBean;
import com.ding.god.tingbei.presenter.ProgramPlayPresenter;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;
import com.ding.god.tingbei.util.BitmapUtil;
import com.ding.god.tingbei.view.iview.IProgramPlayView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class ProgramPlayActivity extends BaseActivity<ProgramPlayPresenter> implements IProgramPlayView {

    @BindView(R.id.pb_activity_program_play)
    ProgressBar pbActivityProgramPlay;
    @BindView(R.id.tv_current_time)
    TextView tvCurrentTime;
    @BindView(R.id.tv_total_time)
    TextView tvTotalTime;
    @BindView(R.id.iv_program_logo)
    ImageView ivProgramLogo;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.iv_play_control)
    ImageView ivPlayControl;
    @BindView(R.id.iv_play_previous)
    ImageView ivPlayPrevious;
    @BindView(R.id.iv_play_next)
    ImageView ivPlayNext;
    @BindView(R.id.rl_play_control)
    RelativeLayout rlPlayControl;
    @BindView(R.id.tv_leave_message)
    TextView tvLeaveMessage;
    @BindView(R.id.rv_activity_radio_play)
    RecyclerView rvActivityRadioPlay;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_program_play_title)
    TextView tvProgramPlayTitle;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.iv_bg)
    ImageView ivBg;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_program_play;
    }

    @Override
    protected void initpresenter() {
        presenter = new ProgramPlayPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {
        setRxBus();
    }


    @Override
    public void initData() {
        Intent intent = getIntent();
        String program_id = intent.getStringExtra("program_id");
        String program_type = intent.getStringExtra("program_type");
        String customer_id = intent.getStringExtra("customer_id");
        presenter.initData(program_id, program_type, customer_id);
    }

    @Override
    public void bindListener() {
        //返回
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //播放暂停
        ivPlayControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.playControl();
            }
        });
    }

    @Override
    public void setView(ProgramInfoBean data) {
        tvProgramPlayTitle.setText(data.getProgram_name());
        mImageUtil.loadURLImage(data.getProgram_image(),ivProgramLogo);
        mImageUtil.loadBlurBitmap(data.getProgram_image(),50,ivBg);

    }

    private void setRxBus() {
        //设置播放键不可点击,并动画
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.IsPrepared.class)
                .compose(RxTransfromer.<PlayControlEvent.IsPrepared>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.IsPrepared>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.IsPrepared isPrepared) throws Exception {
                        ivPlayControl.setClickable(false);
                    }
                });
        //将播放变为暂停样式
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.Started.class)
                .compose(RxTransfromer.<PlayControlEvent.Started>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.Started>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.Started started) throws Exception {
                        ivPlayControl.setClickable(true);
                        ivPlayControl.setSelected(true);
                    }
                });

        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.Stoped.class)
                .compose(RxTransfromer.<PlayControlEvent.Stoped>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.Stoped>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.Stoped stoped) throws Exception {
                        ivPlayControl.setSelected(false);
                    }
                });

    }


}
