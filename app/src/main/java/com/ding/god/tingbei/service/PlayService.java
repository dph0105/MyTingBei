package com.ding.god.tingbei.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.dbbean.PlayRadioHistory;
import com.ding.god.tingbei.gen.DaoSession;
import com.ding.god.tingbei.model.bean.ProgramListBean;
import com.ding.god.tingbei.model.bean.RadioInfoBean;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;
import com.ding.god.tingbei.util.cacheutil.SPUtil;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayService extends Service {
    private IjkMediaPlayer ijkMediaPlayer;

    public static final String SP_PLAY_TYPE_KEY = "PLAY_TYPE";
    public static final String SP_PLAY_POSITION_KEY = "PLAY_POSITION";

    public static final int PLAYSTATE_NULL = 0;     //闲置状态
    public static final int PLAYSTATE_PLAYING = 1;  //正在播放
    public static final int PLAYSTATE_PAUSE = 2;    //暂停状态

    public static final int PLAY_TYPE_PROGRAM = 1;
    public static final int PLAY_TYPE_RADIO = 2;

    public static int playType = 0;
    public static int playState = 0;
    public static int playPosition = 0;                //播放的是第几首

    private String stream = null;
    private long currentPosition;

    private List<ProgramListBean> programList;                //播放数据;
    private List<RadioInfoBean> radioInfoList;

    public PlayService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ServicePlay", "onCreate()");
        ijkMediaPlayer = new IjkMediaPlayer();
        setRxBus();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("ServicePlay", "onStartCommand()");
        return START_STICKY;
    }



    private void setRxBus() {

        RxBus.getRxBus().toFlowable(PlayControlEvent.StartPlayRefresh.class)
                .compose(RxTransfromer.<PlayControlEvent.StartPlayRefresh>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StartPlayRefresh>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StartPlayRefresh startPlayRefresh) throws Exception {

                        playPosition = SPUtil.getInt(getApplicationContext(), SP_PLAY_POSITION_KEY);
                        playType = SPUtil.getInt(getApplicationContext(),SP_PLAY_TYPE_KEY);
                        if(playType==PlayService.PLAY_TYPE_PROGRAM) {
                            stream = programList.get(playPosition).getProgram_file();
                        }else if(playType == PlayService.PLAY_TYPE_RADIO) {
                            stream = radioInfoList.get(0).getLive_stream();
                        }
                        if(ijkMediaPlayer.getDataSource()==null) {
                            Log.d("stream",stream);
                            ijkMediaPlayer.setDataSource(stream);  //设置播放源
                            ijkMediaPlayer.prepareAsync();                                            //异步准备
                            ijkMediaPlayer.setOnPreparedListener(new IjkPrepareListener());
                            RxBus.getRxBus().postSticky(new PlayControlEvent.IsPrepared());
                        }else {
                            if(!ijkMediaPlayer.getDataSource().equals(stream)) {
                                ijkMediaPlayer.reset();
                                ijkMediaPlayer.setDataSource(stream);  //设置播放源
                                ijkMediaPlayer.prepareAsync();                                            //异步准备
                                ijkMediaPlayer.setOnPreparedListener(new IjkPrepareListener());
                                RxBus.getRxBus().postSticky(new PlayControlEvent.IsPrepared());
                            }
                        }

                    }
                });

        //接受播放消息
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.StartPlay.class)
                .compose(RxTransfromer.<PlayControlEvent.StartPlay>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StartPlay>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StartPlay startPlay) throws Exception {
                        if(!ijkMediaPlayer.isPlaying()) {
                            ijkMediaPlayer.start();
                            playState = PLAYSTATE_PLAYING;
                            RxBus.getRxBus().postSticky(new PlayControlEvent.Started());
                        }
                    }
                });
        //接受暂停消息
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.StopPlay.class)
                .compose(RxTransfromer.<PlayControlEvent.StopPlay>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StopPlay>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StopPlay stopPlay) throws Exception {
                        if(ijkMediaPlayer.isPlaying()) {
                            ijkMediaPlayer.pause();
                            currentPosition = ijkMediaPlayer.getCurrentPosition();
                            playState = PLAYSTATE_PAUSE;
                            RxBus.getRxBus().postSticky(new PlayControlEvent.Stoped());
                        }
                    }
                });
        //接受上一首或下一首消息
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.PreviousOrNext.class)
                .compose(RxTransfromer.<PlayControlEvent.PreviousOrNext>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.PreviousOrNext>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.PreviousOrNext previousOrNext) throws Exception {

                    }
                });
        //更换进度
        RxBus.getRxBus().toFlowable(PlayControlEvent.RateOfProgress.class)
                .compose(RxTransfromer.<PlayControlEvent.RateOfProgress>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.RateOfProgress>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.RateOfProgress rateOfProgress) throws Exception {

                    }
                });

        //刷新歌单数据
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.PreData.class)
                .compose(RxTransfromer.<PlayControlEvent.PreData>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.PreData>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.PreData preData) throws Exception {
                        new Thread(new Runnable() {

                            @Override
                            public void run() {
                                programList = MyApplication.getInstance().getDaoSession().getProgramListBeanDao().loadAll();
                                radioInfoList = MyApplication.getInstance().getDaoSession().getRadioInfoBeanDao().loadAll();
                                playType = SPUtil.getInt(getApplicationContext(),SP_PLAY_TYPE_KEY);
                                if(playType == PLAY_TYPE_RADIO) {
                                    RxBus.getRxBus().postSticky(new PlayControlEvent.StartPlayRefresh());
                                }
                            }
                        }).start();
                    }
                });
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ServicePlay", "onDestroy()");
        ijkMediaPlayer.release();
    }

    private class IjkPrepareListener implements IMediaPlayer.OnPreparedListener{
        @Override
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            RxBus.getRxBus().postSticky(new PlayControlEvent.Started());
            iMediaPlayer.start();
            playState = PLAYSTATE_PLAYING;
        }
    }



}
