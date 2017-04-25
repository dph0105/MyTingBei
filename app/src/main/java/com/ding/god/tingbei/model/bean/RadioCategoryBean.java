package com.ding.god.tingbei.model.bean;

import java.util.List;

/**
 * Created by god on 2017/4/25.
 */

public class RadioCategoryBean {

    private List<LocationBean> location;
    private List<StyleBean> style;

    public List<LocationBean> getLocation() {
        return location;
    }

    public void setLocation(List<LocationBean> location) {
        this.location = location;
    }

    public List<StyleBean> getStyle() {
        return style;
    }

    public void setStyle(List<StyleBean> style) {
        this.style = style;
    }

    public static class LocationBean {
        /**
         * category_id : Goqor7TJvd2S9GX
         * category_name : 国家台
         * category_index : 1
         */

        private String category_id;
        private String category_name;
        private String category_index;

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_index() {
            return category_index;
        }

        public void setCategory_index(String category_index) {
            this.category_index = category_index;
        }
    }

    public static class StyleBean {
        /**
         * category_id : fE2pj5YIQb4scJ4
         * category_name : 音乐娱乐
         * category_index : 1
         */

        private String category_id;
        private String category_name;
        private String category_index;

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_index() {
            return category_index;
        }

        public void setCategory_index(String category_index) {
            this.category_index = category_index;
        }
    }
}
