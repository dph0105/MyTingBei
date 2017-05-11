package com.ding.god.tingbei.rx.event;

import com.ding.god.tingbei.model.bean.RadioBean;
import com.ding.god.tingbei.model.bean.RadioInfoBean;

/**
 * Created by Administrator on 2017/5/11.
 */

public class PlayControlEvent {

    public static class StartPlay{


        private RadioInfoBean radioInfoBean;

        public RadioInfoBean getRadioBean() {
            return radioInfoBean;
        }

        public void setRadioBean(RadioInfoBean radioBean) {
            this.radioInfoBean = radioBean;
        }
    }
    public static class StopPlay{

    }
    public static class RateOfProgress{

    }
    public static class PreviousOrNext{

    }
    public static class IsPrepared{

    }
    public static class Started{

    }
    public static class Stoped{

    }

}
