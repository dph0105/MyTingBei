package com.ding.god.tingbei.model;

import android.content.Context;

import com.ding.god.tingbei.MyApplication;
import com.ding.god.tingbei.base.BaseModel;
import com.ding.god.tingbei.dbbean.PlayRadioHistory;
import com.ding.god.tingbei.gen.ProgramListBeanDao;
import com.ding.god.tingbei.model.bean.ProgramListBean;
import com.ding.god.tingbei.service.PlayService;
import com.ding.god.tingbei.util.cacheutil.SPUtil;

import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Administrator on 2017/5/6.
 */

public class ProgramListModel extends BaseModel {

    private ProgramListBeanDao programListBeanDao = daoSession.getProgramListBeanDao();

    public void setPlayType(Context context){
        SPUtil.putInt(context, PlayService.SP_PLAY_TYPE_KEY, PlayService.PLAY_TYPE_PROGRAM);
    }

    public void storeData(List<ProgramListBean> datas){

        long count = programListBeanDao.count();
        ProgramListBean programListBean = programListBeanDao.load(count - 1);
        ProgramListBean data = datas.get(datas.size() - 1);
        if(programListBean!=null) {
            if(data.getAlbum_id().equals(programListBean.getAlbum_id())) {      //如果是同一部作品
                if(!datas.get(datas.size()-1).getProgram_id().equals(programListBean.getProgram_id())) { //如果不是同一集,则添加数据库
                    daoSession.getProgramListBeanDao().insertInTx(datas);
                }
            }else {  //如果不是同一部作品,则清空数据库,再添加数据库
                clearData();
                daoSession.getProgramListBeanDao().insertInTx(datas);
            }
        }else {
            daoSession.getProgramListBeanDao().insertInTx(datas);
        }

    }

    public void clearData(){
        programListBeanDao.deleteAll();
    }

}
