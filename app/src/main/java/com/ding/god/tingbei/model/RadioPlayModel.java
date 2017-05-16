package com.ding.god.tingbei.model;

import android.content.Context;
import android.util.Log;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.model.bean.RadioInfoBean;
import com.ding.god.tingbei.service.PlayService;
import com.ding.god.tingbei.util.cacheutil.SPUtil;

import org.greenrobot.greendao.annotation.Id;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public class RadioPlayModel extends BaseModel {

    public static final String RADIO_STORE_TIME = "RADIO_TIME";

    private RadioInfoBean radioInfoBean;

    public RadioInfoBean getRadioInfoBean() {
        return radioInfoBean;
    }

    public void setRadioInfoBean(Context context, RadioInfoBean radioInfoBean) {

        SPUtil.putInt(context,PlayService.SP_PLAY_TYPE_KEY,PlayService.PLAY_TYPE_RADIO);

        this.radioInfoBean = radioInfoBean;
        List<RadioInfoBean> radios = daoSession.getRadioInfoBeanDao().loadAll();
        int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        int lastTime = SPUtil.getInt(context, RADIO_STORE_TIME);
        if(radios==null||radios.size()==0) {
            daoSession.getRadioInfoBeanDao().insert(radioInfoBean);
            SPUtil.putInt(context,RADIO_STORE_TIME,day);
        }else {
            if(radios.get(0).getProgram_list_id().equals(radioInfoBean.getProgram_list_id())) {
                if(day>lastTime) {
                    daoSession.getRadioInfoBeanDao().deleteAll();
                    daoSession.getRadioInfoBeanDao().insert(radioInfoBean);
                    SPUtil.putInt(context,RADIO_STORE_TIME,day);
                }
            }
        }
    }
}
