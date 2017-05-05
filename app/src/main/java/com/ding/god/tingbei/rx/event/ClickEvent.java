package com.ding.god.tingbei.rx.event;

/**
 * Created by Administrator on 2017/5/5.
 */

public class ClickEvent {

    public static class CategoryPopupClickEvent{
        public int position;

        public CategoryPopupClickEvent(int position) {
            this.position = position;
        }
    }
}
