package com.ding.god.tingbei.model.bean;

import java.util.List;

/**
 * Created by god on 2017/4/25.
 */

public class RadioTypeBean {

    /**
     * category_id : hffn8b7oRocxxVQ
     * category_index : 1
     * category_name : 有声小说
     * category_nick : 有声小说
     * category_image : http://image.tinberfm.com//uploadnew/103551488261240.png
     * create_time : 2016-11-25 14:29:42
     * sub_category : [{"category_id":"QiNSjB7xjsPMI6D","category_index":"1","category_name":"现代都市","category_nick":"","category_image":"http://image.tinberfm.com//uploadnew/894821480054265.png","create_time":"2016-11-25 14:11:09"},{"category_id":"TcxlphLLwVBBiP8","category_index":"1","category_name":"青春校园","category_nick":"","category_image":"http://image.tinberfm.com//uploadnew/409621480054282.png","create_time":"2016-11-25 14:11:26"},{"category_id":"16mS0vdbbjgooq0","category_index":"1","category_name":"穿越架空","category_nick":"","category_image":"http://image.tinberfm.com//uploadnew/551141480054300.png","create_time":"2016-11-25 14:11:43"},{"category_id":"Yx5am3x5tpsXelq","category_index":"1","category_name":"武侠修真","category_nick":"","category_image":"http://image.tinberfm.com//uploadnew/345341480054315.png","create_time":"2016-11-25 14:11:59"},{"category_id":"4sDb79Rd8AzPSI4","category_index":"1","category_name":"古风言情","category_nick":"","category_image":"http://image.tinberfm.com//uploadnew/147561480054331.png","create_time":"2016-11-25 14:12:14"},{"category_id":"NBTorCEBuE2jG4O","category_index":"1","category_name":"悬疑灵异","category_nick":"","category_image":"http://image.tinberfm.com//uploadnew/422631480054348.png","create_time":"2016-11-25 14:12:32"},{"category_id":"zrfLEwx2yEbjdGC","category_index":"1","category_name":"玄幻魔法","category_nick":"","category_image":"http://image.tinberfm.com//uploadnew/300391480054362.png","create_time":"2016-11-25 14:12:45","sub_category":[]},{"category_id":"9RIDckhA06OetLU","category_index":"999","category_name":"文学小说","category_nick":"","category_image":"","create_time":"2017-04-10 10:26:05","sub_category":[]},{"category_id":"7Jx1yFhm4RfR99p","category_index":"999","category_name":"影视原著","category_nick":"","category_image":"","create_time":"2017-04-10 10:26:06","sub_category":[]}]
     */

    private String category_id;
    private String category_index;
    private String category_name;
    private String category_nick;
    private String category_image;
    private String create_time;
    private List<SubCategoryBean> sub_category;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_index() {
        return category_index;
    }

    public void setCategory_index(String category_index) {
        this.category_index = category_index;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_nick() {
        return category_nick;
    }

    public void setCategory_nick(String category_nick) {
        this.category_nick = category_nick;
    }

    public String getCategory_image() {
        return category_image;
    }

    public void setCategory_image(String category_image) {
        this.category_image = category_image;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public List<SubCategoryBean> getSub_category() {
        return sub_category;
    }

    public void setSub_category(List<SubCategoryBean> sub_category) {
        this.sub_category = sub_category;
    }

    public static class SubCategoryBean {
        /**
         * category_id : QiNSjB7xjsPMI6D
         * category_index : 1
         * category_name : 现代都市
         * category_nick :
         * category_image : http://image.tinberfm.com//uploadnew/894821480054265.png
         * create_time : 2016-11-25 14:11:09
         * sub_category : []
         */

        private String category_id;
        private String category_index;
        private String category_name;
        private String category_nick;
        private String category_image;
        private String create_time;
        private List<?> sub_category;

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getCategory_index() {
            return category_index;
        }

        public void setCategory_index(String category_index) {
            this.category_index = category_index;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_nick() {
            return category_nick;
        }

        public void setCategory_nick(String category_nick) {
            this.category_nick = category_nick;
        }

        public String getCategory_image() {
            return category_image;
        }

        public void setCategory_image(String category_image) {
            this.category_image = category_image;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public List<?> getSub_category() {
            return sub_category;
        }

        public void setSub_category(List<?> sub_category) {
            this.sub_category = sub_category;
        }
    }
}
