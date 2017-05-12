package com.ding.god.tingbei.rx.event;

import com.ding.god.tingbei.model.bean.RadioInfoBean;
import com.ding.god.tingbei.model.bean.ProgramInfoBean;

/**
 * Created by Administrator on 2017/5/11.
 */

public class PlayControlEvent {

    public static class StartPlayRefresh{

        private RadioInfoBean radioInfoBean;
        private ProgramInfoBean programInfoBean;
        public RadioInfoBean getRadioInfoBean() {
            return radioInfoBean;
        }

        public void setRadioInfoBean(RadioInfoBean radioBean) {
            this.radioInfoBean = radioBean;
        }

        public ProgramInfoBean getProgramInfoBean() {
            return programInfoBean;
        }

        public void setProgramInfoBean(ProgramInfoBean programInfoBean) {
            this.programInfoBean = programInfoBean;
        }
    }


    public static class StartPlay{

        private ProgramInfoBean programInfoBean;
        private RadioInfoBean radioInfoBean;

        public RadioInfoBean getRadioBean() {
            return radioInfoBean;
        }

        public void setRadioBean(RadioInfoBean radioBean) {
            this.radioInfoBean = radioBean;
        }

        public ProgramInfoBean getProgramInfoBean() {
            return programInfoBean;
        }

        public void setProgramInfoBean(ProgramInfoBean programInfoBean) {
            this.programInfoBean = programInfoBean;
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
