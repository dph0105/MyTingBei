package com.ding.god.tingbei.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayService extends Service {
    private IjkMediaPlayer ijkMediaPlayer;
    public static final int PLAYSTATE_NULL = 0;     //闲置状态
    public static final int PLAYSTATE_PLAYING = 1;  //正在播放
    public static final int PLAYSTATE_PAUSE = 2;    //暂停状态
    private long currentPosition;
    private static int playState = 0;

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
                        String stream = startPlayRefresh.getProgramInfoBean()==null?startPlayRefresh.getRadioInfoBean().getLive_stream():startPlayRefresh.getProgramInfoBean().getProgram_file();
                        if (ijkMediaPlayer.getDataSource()!=null){
                            if (!ijkMediaPlayer.getDataSource().equals(stream)){
                                ijkMediaPlayer.reset();
                                ijkMediaPlayer.setDataSource(stream);  //设置播放源
                                ijkMediaPlayer.prepareAsync();                                            //异步准备
                                ijkMediaPlayer.setOnPreparedListener(new IjkPrepareListener());
                                RxBus.getRxBus().postSticky(new PlayControlEvent.IsPrepared());
                            }else {
                                if (!ijkMediaPlayer.isPlaying()){
                                    ijkMediaPlayer.start();
                                    playState = PLAYSTATE_PLAYING;
                                }
                                RxBus.getRxBus().post(new PlayControlEvent.Started());
                            }
                        }else {
                            ijkMediaPlayer.setDataSource(stream);  //设置播放源
                            ijkMediaPlayer.prepareAsync();                                            //异步准备
                            ijkMediaPlayer.setOnPreparedListener(new IjkPrepareListener());
                            RxBus.getRxBus().postSticky(new PlayControlEvent.IsPrepared());
                        }

                    }
                });

        //接受播放消息
        RxBus.getRxBus().toFlowableSticky(PlayControlEvent.StartPlay.class)
                .compose(RxTransfromer.<PlayControlEvent.StartPlay>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StartPlay>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StartPlay startPlay) throws Exception {
                        String stream = startPlay.getProgramInfoBean()==null?startPlay.getRadioBean().getLive_stream():startPlay.getProgramInfoBean().getProgram_file();
                        if (ijkMediaPlayer.getDataSource()!=null){  //判断是否是暂停的，有DataSource没有reset
                            if(ijkMediaPlayer.isPlaying()) {//判断是否正在播放
                                ijkMediaPlayer.reset();
                                ijkMediaPlayer.setDataSource(stream);  //设置播放源
                                ijkMediaPlayer.prepareAsync();                                            //异步准备
                                ijkMediaPlayer.setOnPreparedListener(new IjkPrepareListener());
                                RxBus.getRxBus().postSticky(new PlayControlEvent.IsPrepared());
                            }else {
                                ijkMediaPlayer.start();
                                playState = PLAYSTATE_PLAYING;
                                RxBus.getRxBus().postSticky(new PlayControlEvent.Started());
                            }
                        }else {
                            ijkMediaPlayer.setDataSource(stream);  //设置播放源
                            ijkMediaPlayer.prepareAsync();                                            //异步准备
                            ijkMediaPlayer.setOnPreparedListener(new IjkPrepareListener());
                            RxBus.getRxBus().postSticky(new PlayControlEvent.IsPrepared());
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
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ServicePlay", "onDestroy()");
        ijkMediaPlayer.release();
    }

    class IjkPrepareListener implements IMediaPlayer.OnPreparedListener{
        @Override
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            RxBus.getRxBus().postSticky(new PlayControlEvent.Started());
            iMediaPlayer.start();
            playState = PLAYSTATE_PLAYING;
        }
    }

    public static int getPlayState() {
        return playState;
    }


}
