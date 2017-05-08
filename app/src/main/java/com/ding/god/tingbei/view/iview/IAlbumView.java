package com.ding.god.tingbei.view.iview;

import com.ding.god.tingbei.base.BaseFragment;
import com.ding.god.tingbei.base.IBaseView;
import com.ding.god.tingbei.model.bean.AlbumInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */

public interface IAlbumView extends IBaseView {

    void initAlbumInfo(AlbumInfoBean data);

    void setVPAdapter(List<BaseFragment> fragments, String[] tabTitle);
}
