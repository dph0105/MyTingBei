package com.ding.god.tingbei.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.ding.god.tingbei.gen.DaoSession;
import com.ding.god.tingbei.gen.RadioMenuBeanDao;
import com.ding.god.tingbei.gen.RadioInfoBeanDao;

/**
 * Created by Administrator on 2017/5/8.
 */
@Entity
public class RadioInfoBean {

    @Id(autoincrement = true)
    private Long id;

    /**
     * image_url : http://image.tinberfm.com//uploadnew/991741493171343.jpg
     * ts_diffence : 0
     * program_type : 1
     * program_host : 李雯
     * program_describe : 在音乐中自由畅行，在生活中感怀领悟
     * program_name : 乐动随心
     * program_list_id : lrrq7cWpRJDujvI
     * start_time : 14:00
     * live_stream : http://hls1.gzstv.com/livegztv/yinyue/index.m3u8
     * end_time : 17:00
     * radio_name : 916 贵州音乐 iRadio
     * phone_no :
     * song_state : 1
     * has_menu : 1
     * backward_menu : [{"album_id":"8tKgyNXTHT9BWtP","program_name":"音乐More and More","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"00:00","end_time":"05:00","program_host":"RCS轮播","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"0i7y2WblzkP2IIB","program_name":"专题节目","program_describe":"","start_time":"05:00","end_time":"07:00","program_host":"RCS轮播","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"EaGjb0RhLYFL3dX","program_name":"音乐深呼吸","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"07:00","end_time":"08:00","program_host":"RCS轮播","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"kMUvAWCWQpW5WyK","program_name":"周末ING","program_describe":"最舒心音乐的陪伴，让你能量满满","start_time":"08:00","end_time":"10:00","program_host":"裙子","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"okfyQfQOEfXbdfN","program_name":"ASIA POP 40","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"10:00","end_time":"13:00","program_host":"暂无","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"e1yoDDmArlDJOIo","program_name":"岁月如歌","program_describe":"","start_time":"13:00","end_time":"14:00","program_host":"张 露","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"qL5IKqpCUyd0cqc","program_name":"原创贵州","program_describe":"资深女主播濮琳，为你打开贵州上空最美的声音，一同感受贵州的风土人情","start_time":"14:00","end_time":"15:00","program_host":"濮琳","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"20RTE6rSQmDwvYK","program_name":"远誉快车道","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"15:00","end_time":"16:00","program_host":"远誉制作","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"24qL1JuSVd7TKrH","program_name":"来呗音乐","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"16:00","end_time":"19:00","program_host":"洋溢","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"gkM26q6kWtZW65G","program_name":"都市夜未眠","program_describe":"每一首歌曲都是一个故事，每一个故事都有你的影子","start_time":"19:00","end_time":"21:00","program_host":"尔东","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"LP9aAWXFWXPTnCY","program_name":"音乐先锋榜","program_describe":"全中国覆盖最广泛的流行歌曲排行榜节目。音乐先锋榜，给你音乐正能量~","start_time":"21:00","end_time":"23:00","program_host":"亚东","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"2GnMFsUi2gxvJla","program_name":"音乐More and More","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"23:00","end_time":"23:59","program_host":"RCS轮播","phone_no":"","day":"7","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1}]
     * current_menu : [{"album_id":"8tKgyNXTHT9BWtP","program_name":"音乐More and More","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"00:00","end_time":"04:00","program_host":"RCS轮播","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"EaGjb0RhLYFL3dX","program_name":"音乐深呼吸","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"04:00","end_time":"05:00","program_host":"RCS轮播","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"0i7y2WblzkP2IIB","program_name":"专题节目","program_describe":"","start_time":"05:00","end_time":"07:00","program_host":"RCS轮播","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"Jijo7vtc3ktbKVU","program_name":"RADIO早安秀","program_describe":"音乐资讯，RADIO早安秀给你活力无限","start_time":"07:00","end_time":"09:00","program_host":"吴 旭、陈 可","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"2sH4ZaZDINn1u3s","program_name":"裙摆摇摇","program_describe":"裙摆摇摇 在音乐中享受美好","start_time":"09:00","end_time":"11:00","program_host":"裙子","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"EEKo8eEoczYGVH8","program_name":"亚东 ON LINE","program_describe":"有音乐才够味；有娱乐才劲爆；有亚东才有料！亚东on line，听了就知道！","start_time":"11:00","end_time":"13:00","program_host":"亚东","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"SuIy5rmqpzMuzZl","program_name":"岁月如歌","program_describe":"慢寻如歌的回忆，感受岁月的温情","start_time":"13:00","end_time":"14:00","program_host":"张 露","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"lrrq7cWpRJDujvI","program_name":"乐动随心","program_describe":"在音乐中自由畅行，在生活中感怀领悟","start_time":"14:00","end_time":"17:00","program_host":"李雯","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"Lxm98lNg0QCKw5Z","program_name":"MYSHOW麦克秀","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"17:00","end_time":"19:00","program_host":"燕 妮、李 逸","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"yHseOkW1dApDGE6","program_name":"你点的歌","program_describe":"","start_time":"19:00","end_time":"20:00","program_host":"小妮","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"iTBQeGboI5eyPfO","program_name":"爱听FUN轻松","program_describe":"聆听放松的音乐，感受这个城市的车水马龙","start_time":"20:00","end_time":"22:00","program_host":"洋溢","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"z32QQp5KfdSghxI","program_name":"音乐夜飞行 ","program_describe":"最具有年代感的经典音乐，与深夜的静谧气氛融为一体。与尔东一同聆听那些属于过去的音乐故事~","start_time":"22:00","end_time":"23:59","program_host":"尔东","phone_no":"","day":"1","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1}]
     * forward_menu : [{"album_id":"8tKgyNXTHT9BWtP","program_name":"音乐More and More","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"00:00","end_time":"04:00","program_host":"RCS轮播","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"EaGjb0RhLYFL3dX","program_name":"音乐深呼吸","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"04:00","end_time":"05:00","program_host":"RCS轮播","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"0i7y2WblzkP2IIB","program_name":"专题节目","program_describe":"","start_time":"05:00","end_time":"07:00","program_host":"RCS轮播","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"Jijo7vtc3ktbKVU","program_name":"RADIO早安秀","program_describe":"音乐资讯，RADIO早安秀给你活力无限","start_time":"07:00","end_time":"09:00","program_host":"吴 旭、陈 可","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"2sH4ZaZDINn1u3s","program_name":"裙摆摇摇","program_describe":"裙摆摇摇 在音乐中享受美好","start_time":"09:00","end_time":"11:00","program_host":"裙子","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"EEKo8eEoczYGVH8","program_name":"亚东 ON LINE","program_describe":"有音乐才够味；有娱乐才劲爆；有亚东才有料！亚东on line，听了就知道！","start_time":"11:00","end_time":"13:00","program_host":"亚东","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"SuIy5rmqpzMuzZl","program_name":"岁月如歌","program_describe":"慢寻如歌的回忆，感受岁月的温情","start_time":"13:00","end_time":"14:00","program_host":"张 露","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"lrrq7cWpRJDujvI","program_name":"乐动随心","program_describe":"在音乐中自由畅行，在生活中感怀领悟","start_time":"14:00","end_time":"17:00","program_host":"李雯","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"Lxm98lNg0QCKw5Z","program_name":"MYSHOW麦克秀","program_describe":"为你私人定制的音乐电台，让我们一起来收听最好的音乐","start_time":"17:00","end_time":"19:00","program_host":"燕 妮、李 逸","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"yHseOkW1dApDGE6","program_name":"你点的歌","program_describe":"","start_time":"19:00","end_time":"20:00","program_host":"小妮","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"iTBQeGboI5eyPfO","program_name":"爱听FUN轻松","program_describe":"聆听放松的音乐，感受这个城市的车水马龙","start_time":"20:00","end_time":"22:00","program_host":"洋溢","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1},{"album_id":"z32QQp5KfdSghxI","program_name":"音乐夜飞行 ","program_describe":"最具有年代感的经典音乐，与深夜的静谧气氛融为一体。与尔东一同聆听那些属于过去的音乐故事~","start_time":"22:00","end_time":"23:59","program_host":"尔东","phone_no":"","day":"2","live_stream":"http://hls1.gzstv.com/livegztv/yinyue/index.m3u8","radio_name":"916 贵州音乐 iRadio","program_type":1}]
     */

    private String image_url;
    private int ts_diffence;
    private int program_type;
    private String program_host;
    private String program_describe;
    private String program_name;
    private String program_list_id;
    private String start_time;
    private String live_stream;
    private String end_time;
    private String radio_name;
    private String phone_no;
    private int song_state;
    private String has_menu;
    @ToMany(referencedJoinProperty = "fid")
    private List<RadioMenuBean> backward_menu;
    @ToMany(referencedJoinProperty = "fid")
    private List<RadioMenuBean> current_menu;
    @ToMany(referencedJoinProperty = "fid")
    private List<RadioMenuBean> forward_menu;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 6537750)
    private transient RadioInfoBeanDao myDao;
    @Generated(hash = 963148467)
    public RadioInfoBean(Long id, String image_url, int ts_diffence, int program_type, String program_host, String program_describe, String program_name, String program_list_id, String start_time, String live_stream, String end_time, String radio_name, String phone_no, int song_state, String has_menu) {
        this.id = id;
        this.image_url = image_url;
        this.ts_diffence = ts_diffence;
        this.program_type = program_type;
        this.program_host = program_host;
        this.program_describe = program_describe;
        this.program_name = program_name;
        this.program_list_id = program_list_id;
        this.start_time = start_time;
        this.live_stream = live_stream;
        this.end_time = end_time;
        this.radio_name = radio_name;
        this.phone_no = phone_no;
        this.song_state = song_state;
        this.has_menu = has_menu;
    }
    @Generated(hash = 1998898844)
    public RadioInfoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public int getTs_diffence() {
        return this.ts_diffence;
    }
    public void setTs_diffence(int ts_diffence) {
        this.ts_diffence = ts_diffence;
    }
    public int getProgram_type() {
        return this.program_type;
    }
    public void setProgram_type(int program_type) {
        this.program_type = program_type;
    }
    public String getProgram_host() {
        return this.program_host;
    }
    public void setProgram_host(String program_host) {
        this.program_host = program_host;
    }
    public String getProgram_describe() {
        return this.program_describe;
    }
    public void setProgram_describe(String program_describe) {
        this.program_describe = program_describe;
    }
    public String getProgram_name() {
        return this.program_name;
    }
    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }
    public String getProgram_list_id() {
        return this.program_list_id;
    }
    public void setProgram_list_id(String program_list_id) {
        this.program_list_id = program_list_id;
    }
    public String getStart_time() {
        return this.start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getLive_stream() {
        return this.live_stream;
    }
    public void setLive_stream(String live_stream) {
        this.live_stream = live_stream;
    }
    public String getEnd_time() {
        return this.end_time;
    }
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public String getRadio_name() {
        return this.radio_name;
    }
    public void setRadio_name(String radio_name) {
        this.radio_name = radio_name;
    }
    public String getPhone_no() {
        return this.phone_no;
    }
    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
    public int getSong_state() {
        return this.song_state;
    }
    public void setSong_state(int song_state) {
        this.song_state = song_state;
    }
    public String getHas_menu() {
        return this.has_menu;
    }
    public void setHas_menu(String has_menu) {
        this.has_menu = has_menu;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1582262385)
    public List<RadioMenuBean> getBackward_menu() {
        if (backward_menu == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RadioMenuBeanDao targetDao = daoSession.getRadioMenuBeanDao();
            List<RadioMenuBean> backward_menuNew = targetDao._queryRadioInfoBean_Backward_menu(id);
            synchronized (this) {
                if (backward_menu == null) {
                    backward_menu = backward_menuNew;
                }
            }
        }
        return backward_menu;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1126797963)
    public synchronized void resetBackward_menu() {
        backward_menu = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1498006711)
    public List<RadioMenuBean> getCurrent_menu() {
        if (current_menu == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RadioMenuBeanDao targetDao = daoSession.getRadioMenuBeanDao();
            List<RadioMenuBean> current_menuNew = targetDao._queryRadioInfoBean_Current_menu(id);
            synchronized (this) {
                if (current_menu == null) {
                    current_menu = current_menuNew;
                }
            }
        }
        return current_menu;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 708703928)
    public synchronized void resetCurrent_menu() {
        current_menu = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1350176708)
    public List<RadioMenuBean> getForward_menu() {
        if (forward_menu == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RadioMenuBeanDao targetDao = daoSession.getRadioMenuBeanDao();
            List<RadioMenuBean> forward_menuNew = targetDao._queryRadioInfoBean_Forward_menu(id);
            synchronized (this) {
                if (forward_menu == null) {
                    forward_menu = forward_menuNew;
                }
            }
        }
        return forward_menu;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1439295375)
    public synchronized void resetForward_menu() {
        forward_menu = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1334327813)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRadioInfoBeanDao() : null;
    }

    @Override
    public String toString() {
        return "RadioInfoBean{" +
                "id=" + id +
                ", image_url='" + image_url + '\'' +
                ", ts_diffence=" + ts_diffence +
                ", program_type=" + program_type +
                ", program_host='" + program_host + '\'' +
                ", program_describe='" + program_describe + '\'' +
                ", program_name='" + program_name + '\'' +
                ", program_list_id='" + program_list_id + '\'' +
                ", start_time='" + start_time + '\'' +
                ", live_stream='" + live_stream + '\'' +
                ", end_time='" + end_time + '\'' +
                ", radio_name='" + radio_name + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", song_state=" + song_state +
                ", has_menu='" + has_menu + '\'' +
                ", backward_menu=" + backward_menu +
                ", current_menu=" + current_menu +
                ", forward_menu=" + forward_menu +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}
