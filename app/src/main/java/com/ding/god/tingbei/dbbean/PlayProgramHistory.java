package com.ding.god.tingbei.dbbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/5/15.
 */
@Entity
public class PlayProgramHistory {
    @Id(autoincrement = true)
    private Long id;

    private String program_id;
    private String program_name;
    private String program_describe;
    private String program_host;
    private String program_type;
    private String program_file;
    private String program_size;
    private String program_duration;
    private String program_image;
    private String program_date;
    private String album_id;
    private String album_name;
    private String album_logo;
    private int thumbs_up_number;
    private int comment_number;
    private boolean thumbs_state;
    private int play_amount;
    private int historyTime;
    private long listenTime;
    @Generated(hash = 319306468)
    public PlayProgramHistory(Long id, String program_id, String program_name,
            String program_describe, String program_host, String program_type,
            String program_file, String program_size, String program_duration,
            String program_image, String program_date, String album_id,
            String album_name, String album_logo, int thumbs_up_number,
            int comment_number, boolean thumbs_state, int play_amount,
            int historyTime, long listenTime) {
        this.id = id;
        this.program_id = program_id;
        this.program_name = program_name;
        this.program_describe = program_describe;
        this.program_host = program_host;
        this.program_type = program_type;
        this.program_file = program_file;
        this.program_size = program_size;
        this.program_duration = program_duration;
        this.program_image = program_image;
        this.program_date = program_date;
        this.album_id = album_id;
        this.album_name = album_name;
        this.album_logo = album_logo;
        this.thumbs_up_number = thumbs_up_number;
        this.comment_number = comment_number;
        this.thumbs_state = thumbs_state;
        this.play_amount = play_amount;
        this.historyTime = historyTime;
        this.listenTime = listenTime;
    }
    @Generated(hash = 1034273558)
    public PlayProgramHistory() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProgram_id() {
        return this.program_id;
    }
    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }
    public String getProgram_name() {
        return this.program_name;
    }
    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }
    public String getProgram_describe() {
        return this.program_describe;
    }
    public void setProgram_describe(String program_describe) {
        this.program_describe = program_describe;
    }
    public String getProgram_host() {
        return this.program_host;
    }
    public void setProgram_host(String program_host) {
        this.program_host = program_host;
    }
    public String getProgram_type() {
        return this.program_type;
    }
    public void setProgram_type(String program_type) {
        this.program_type = program_type;
    }
    public String getProgram_file() {
        return this.program_file;
    }
    public void setProgram_file(String program_file) {
        this.program_file = program_file;
    }
    public String getProgram_size() {
        return this.program_size;
    }
    public void setProgram_size(String program_size) {
        this.program_size = program_size;
    }
    public String getProgram_duration() {
        return this.program_duration;
    }
    public void setProgram_duration(String program_duration) {
        this.program_duration = program_duration;
    }
    public String getProgram_image() {
        return this.program_image;
    }
    public void setProgram_image(String program_image) {
        this.program_image = program_image;
    }
    public String getProgram_date() {
        return this.program_date;
    }
    public void setProgram_date(String program_date) {
        this.program_date = program_date;
    }
    public String getAlbum_id() {
        return this.album_id;
    }
    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }
    public String getAlbum_name() {
        return this.album_name;
    }
    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }
    public String getAlbum_logo() {
        return this.album_logo;
    }
    public void setAlbum_logo(String album_logo) {
        this.album_logo = album_logo;
    }
    public int getThumbs_up_number() {
        return this.thumbs_up_number;
    }
    public void setThumbs_up_number(int thumbs_up_number) {
        this.thumbs_up_number = thumbs_up_number;
    }
    public int getComment_number() {
        return this.comment_number;
    }
    public void setComment_number(int comment_number) {
        this.comment_number = comment_number;
    }
    public boolean getThumbs_state() {
        return this.thumbs_state;
    }
    public void setThumbs_state(boolean thumbs_state) {
        this.thumbs_state = thumbs_state;
    }
    public int getPlay_amount() {
        return this.play_amount;
    }
    public void setPlay_amount(int play_amount) {
        this.play_amount = play_amount;
    }
    public int getHistoryTime() {
        return this.historyTime;
    }
    public void setHistoryTime(int historyTime) {
        this.historyTime = historyTime;
    }
    public long getListenTime() {
        return this.listenTime;
    }
    public void setListenTime(long listenTime) {
        this.listenTime = listenTime;
    }
}
