package com.ding.god.tingbei.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ding.god.tingbei.R;
import com.ding.god.tingbei.customview.PlayBar;
import com.ding.god.tingbei.rx.RxBus;
import com.ding.god.tingbei.util.ImageUtil;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class PlayBarBaseActivity<P extends BasePresenter> extends RxAppCompatActivity implements IBaseView {

    protected P presenter;
    protected Context mContext;
    protected ImageUtil mImageUtil;
    private PlayBar playBar;
    private FrameLayout viewContainer;



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
    }

    protected abstract int getLayoutID();

    protected abstract void initpresenter();

    @Override
    public void toast(String message, int time) {
        if(message!=null&&message.length()!=0) {
            if(time==0) {
                Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(mContext,message,time);
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
