package com.ding.god.tingbei.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.R;
import com.ding.god.tingbei.customview.PlayBar;
import com.ding.god.tingbei.dbbean.PlayProgramHistory;
import com.ding.god.tingbei.dbbean.PlayRadioHistory;
import com.ding.god.tingbei.model.bean.ProgramInfoBean;
import com.ding.god.tingbei.model.bean.RadioInfoBean;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;
import com.ding.god.tingbei.service.PlayService;
import com.ding.god.tingbei.util.ImageUtil;
import com.ding.god.tingbei.view.activity.RadioMenuActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public abstract class PlayBarBaseActivity<P extends BasePresenter> extends RxAppCompatActivity implements IBaseView {

    protected P presenter;
    protected Context mContext;
    protected ImageUtil mImageUtil;
    private PlayBar playBar;
    private FrameLayout viewContainer;
    private int type = 0;
    public static final int RADIO = 1;
    public static final int PROGRAM = 2;

    private ProgramInfoBean programInfoBean;
    private RadioInfoBean radioInfoBean;
    private boolean home = true;
    private List<PlayProgramHistory> playProgramHistories;
    private List<PlayRadioHistory> playRadioHistories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_bar_base);
        playBar = ((PlayBar) findViewById(R.id.playbar));
        viewContainer = ((FrameLayout) findViewById(R.id.view_container));
        View view = LayoutInflater.from(PlayBarBaseActivity.this).inflate(getLayoutID(),viewContainer);
        ButterKnife.bind(this,view);
        mContext = this;
        mImageUtil = new ImageUtil(mContext);
        initpresenter();
        initPlayer();
        setRxBus();


    }

    private void setType() {
        if(playProgramHistories.size()==0&&playRadioHistories.size()==0) {
            playBar.setIcon(R.mipmap.play_logo);
            playBar.setTitle("欢迎来到听呗");
            playBar.setDescription("终于等到你了");
            type = 0;
        }else if(playProgramHistories.size()!=0&&playRadioHistories.size()==0) {
            playBar.setIcon(mImageUtil.loadBitmap(playProgramHistories.get(playProgramHistories.size()-1).getProgram_image()));
            playBar.setTitle(playProgramHistories.get(playProgramHistories.size()-1).getProgram_name());
            playBar.setDescription(playProgramHistories.get(playProgramHistories.size()-1).getProgram_describe());
            type = PROGRAM;
        }else if(playProgramHistories.size()==0&&playRadioHistories.size()!=0) {
            playBar.setIcon(mImageUtil.loadBitmap(playRadioHistories.get(playRadioHistories.size()-1).getImage_url()));
            playBar.setTitle(playRadioHistories.get(playRadioHistories.size()-1).getRadio_name());
            playBar.setDescription(playRadioHistories.get(playRadioHistories.size()-1).getProgram_name());
            type = RADIO;
        }else if(playProgramHistories.size()!=0&&playRadioHistories.size()!=0) {
            if(playProgramHistories.get(playProgramHistories.size()-1).getListenTime()>playRadioHistories.get(playRadioHistories.size()-1).getListenTime()) {
                playBar.setIcon(mImageUtil.loadBitmap(playProgramHistories.get(playProgramHistories.size()-1).getProgram_image()));
                playBar.setTitle(playProgramHistories.get(playProgramHistories.size()-1).getProgram_name());
                playBar.setDescription(playProgramHistories.get(playProgramHistories.size()-1).getProgram_describe());
                type = PROGRAM;
            }else {
                playBar.setIcon(mImageUtil.loadBitmap(playRadioHistories.get(playRadioHistories.size()-1).getImage_url()));
                playBar.setTitle(playRadioHistories.get(playRadioHistories.size()-1).getRadio_name());
                playBar.setDescription(playRadioHistories.get(playRadioHistories.size()-1).getProgram_name());
                type = RADIO;
            }
        }
    }


    private void setRxBus() {

        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.StartPlayRefresh.class)
                .compose(RxTransfromer.<PlayControlEvent.StartPlayRefresh>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StartPlayRefresh>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StartPlayRefresh startPlayRefresh) throws Exception {
                        if(startPlayRefresh.getProgramInfoBean()==null) {
                            radioInfoBean = startPlayRefresh.getRadioInfoBean();
                            type = RADIO;
                            playBar.setIcon(mImageUtil.loadBitmap(startPlayRefresh.getRadioInfoBean().getImage_url()));
                            playBar.setTitle(startPlayRefresh.getRadioInfoBean().getRadio_name());
                            playBar.setDescription(startPlayRefresh.getRadioInfoBean().getProgram_name());
                        }else {
                            programInfoBean = startPlayRefresh.getProgramInfoBean();
                            type = PROGRAM;
                            playBar.setIcon(mImageUtil.loadBitmap(startPlayRefresh.getProgramInfoBean().getProgram_image()));
                            playBar.setTitle(startPlayRefresh.getProgramInfoBean().getProgram_name());
                            playBar.setDescription(startPlayRefresh.getProgramInfoBean().getProgram_describe());
                        }
                    }
                });

        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.StartPlay.class)
                .compose(RxTransfromer.<PlayControlEvent.StartPlay>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StartPlay>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StartPlay startPlay) throws Exception {
                        if(startPlay.getProgramInfoBean()==null) {
                            type = RADIO;
                            playBar.setIcon(mImageUtil.loadBitmap(startPlay.getRadioBean().getImage_url()));
                            playBar.setTitle(startPlay.getRadioBean().getRadio_name());
                            playBar.setDescription(startPlay.getRadioBean().getProgram_name());
                        }else {
                            type = PROGRAM;
                            playBar.setIcon(mImageUtil.loadBitmap(startPlay.getProgramInfoBean().getProgram_image()));
                            playBar.setTitle(startPlay.getProgramInfoBean().getProgram_name());
                            playBar.setDescription(startPlay.getProgramInfoBean().getProgram_describe());
                        }
                    }
                });
        //设置播放键不可点击,并动画
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.IsPrepared.class)
                .compose(RxTransfromer.<PlayControlEvent.IsPrepared>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.IsPrepared>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.IsPrepared isPrepared) throws Exception {
                        playBar.setPlayBtnClickable(false);
                    }
                });
        //将播放变为暂停样式
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.Started.class)
                .compose(RxTransfromer.<PlayControlEvent.Started>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.Started>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.Started started) throws Exception {
                        playBar.setPlayBtnClickable(true);
                        playBar.setPlayBtnSelected(true);
                    }
                });

        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.Stoped.class)
                .compose(RxTransfromer.<PlayControlEvent.Stoped>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.Stoped>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.Stoped stoped) throws Exception {
                        playBar.setPlayBtnSelected(false);
                    }
                });
    }


    private void initPlayer() {
        playBar.setPlayListListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type){
                    case RADIO:
                        Intent intent = new Intent(mContext, RadioMenuActivity.class);
                        startActivity(intent);
                        break;
                    case PROGRAM:
                        break;

                }
            }
        });
        playBar.setPlayListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioInfoBean!=null||programInfoBean!=null) {
                    PlayControlEvent.StartPlay startPlay = new PlayControlEvent.StartPlay();
                    switch (type){
                        case RADIO:
                            startPlay.setRadioBean(radioInfoBean);
                            break;
                        case PROGRAM:
                            startPlay.setProgramInfoBean(programInfoBean);
                            break;
                    }
                    if(PlayService.getPlayState()==PlayService.PLAYSTATE_PLAYING) {
                        RxBus.getRxBus().post(new PlayControlEvent.StopPlay());
                    }else {
                        RxBus.getRxBus().post(startPlay);
                    }
                }
            }
        });
    }


    protected abstract int getLayoutID();

    protected abstract void initpresenter();

    @Override
    public void toast(String message, int time) {
        if(message!=null&&message.length()!=0) {
            if(time==0) {
                Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(mContext,message,time).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
        ButterKnife.bind(this).unbind();
        RxBus.getRxBus().removeAllStickyEvents();
    }



}
