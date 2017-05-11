package com.ding.god.tingbei.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.rx.RxTransfromer;
import com.ding.god.tingbei.rx.event.PlayControlEvent;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayService extends Service {
    private IjkMediaPlayer ijkMediaPlayer;
    private long currentPosition;
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
        return super.onStartCommand(intent, flags, startId);
    }



    private void setRxBus() {
        //接受播放消息
        RxBus.getRxBus().toFlowable(PlayControlEvent.StartPlay.class)
                .compose(RxTransfromer.<PlayControlEvent.StartPlay>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StartPlay>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StartPlay startPlay) throws Exception {
                        Log.d("stream",startPlay.toString());
                        if(ijkMediaPlayer.isPlaying()) {
                            ijkMediaPlayer.reset();
                        }
                        ijkMediaPlayer.setDataSource(startPlay.getRadioBean().getLive_stream());  //设置播放源
                        ijkMediaPlayer.prepareAsync();                                            //异步准备
                        ijkMediaPlayer.setOnPreparedListener(new IjkPrepareListener());
                        RxBus.getRxBus().postSticky(new PlayControlEvent.IsPrepared());
                    }
                });
        //接受暂停消息
        RxBus.getRxBus().toFlowable(PlayControlEvent.StopPlay.class)
                .compose(RxTransfromer.<PlayControlEvent.StopPlay>observeOnToMain())
                .subscribe(new Consumer<PlayControlEvent.StopPlay>() {
                    @Override
                    public void accept(@NonNull PlayControlEvent.StopPlay stopPlay) throws Exception {
                        if(ijkMediaPlayer.isPlaying()) {
                            ijkMediaPlayer.pause();
                            currentPosition = ijkMediaPlayer.getCurrentPosition();
                            MyApplication.getInstance().setPlayState(0);
                            RxBus.getRxBus().postSticky(new PlayControlEvent.Stoped());
                        }
                    }
                });
        //接受上一首或下一首消息
        RxBus.getRxBus().toFlowable(PlayControlEvent.PreviousOrNext.class)
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
            MyApplication.getInstance().setPlayState(1);
        }
    }

}
