package com.ding.god.tingbei.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.base.BaseActivity;
import com.ding.god.tingbei.model.bean.RadioInfoBean;
import com.ding.god.tingbei.presenter.RadioPlayPresenter;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;
import com.ding.god.tingbei.view.iview.IRadioPlayView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class RadioPlayActivity extends BaseActivity<RadioPlayPresenter> implements IRadioPlayView {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_radio_play_title)
    TextView tvRadioPlayTitle;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.tv_program_name)
    TextView tvProgramName;
    @BindView(R.id.tv_program_host)
    TextView tvProgramHost;
    @BindView(R.id.tv_program_time)
    TextView tvProgramTime;
    @BindView(R.id.iv_play_control)
    ImageView ivPlayControl;
    @BindView(R.id.iv_play_previous)
    ImageView ivPlayPrevious;
    @BindView(R.id.iv_play_next)
    ImageView ivPlayNext;
    @BindView(R.id.rv_activity_radio_play)
    RecyclerView rvActivityRadioPlay;
    @BindView(R.id.activity_radio_play)
    LinearLayout activityRadioPlay;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_radio_play;
    }

    @Override
    protected void initpresenter() {
        presenter = new RadioPlayPresenter(mContext, this);
        presenter.init();
    }

    @Override
    public void initView() {
        setRxBus();
    }



    @Override
    public void initData() {
        Intent intent = getIntent();
        String radio_id = intent.getStringExtra("radio_id");
        presenter.initData(radio_id);
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
    public void setView(RadioInfoBean data) {
        tvRadioPlayTitle.setText(data.getRadio_name());
        tvProgramName.setText(data.getProgram_name());
        tvProgramHost.setText(data.getProgram_host());
        tvProgramTime.setText(data.getStart_time()+"-"+data.getEnd_time());
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
