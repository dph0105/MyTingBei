package com.ding.god.tingbei.model.bean;

/**
 * Created by Administrator on 2017/4/28.
 */

public class LoadingImgBean {

    /**
     * returnCD : 1
     * message : 获取成功
     * launchName : 岳云鹏
     * loadingImg : http://image.tinberfm.com//launch/201704/301501493006101.jpg
     * countDown : 3
     * jumpingType : 0
     * jumpingContent :
     */

    private int returnCD;
    private String message;
    private String launchName;
    private String loadingImg;
    private int countDown;
    private int jumpingType;
    private String jumpingContent;

    public int getReturnCD() {
        return returnCD;
    }

    public void setReturnCD(int returnCD) {
        this.returnCD = returnCD;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getLoadingImg() {
        return loadingImg;
    }

    public void setLoadingImg(String loadingImg) {
        this.loadingImg = loadingImg;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public int getJumpingType() {
        return jumpingType;
    }

    public void setJumpingType(int jumpingType) {
        this.jumpingType = jumpingType;
    }

    public String getJumpingContent() {
        return jumpingContent;
    }

    public void setJumpingContent(String jumpingContent) {
        this.jumpingContent = jumpingContent;
    }
}
