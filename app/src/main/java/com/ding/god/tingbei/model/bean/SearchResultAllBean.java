package com.ding.god.tingbei.model.bean;

import java.util.List;

/**
 * Created by god on 2017/5/2.
 */

public class SearchResultAllBean {

    /**
     * name : 专辑
     * list : [{"album_id":"12935","album_name":"我是谁","album_logo":"http://pic.qingting.fm/2015/1124/20151124103814956.jpg!400","album_describe":"优酷出品 - 首档互联网大型纪实类真人秀《我是谁》，陈小春、华晨宇、葛天、汪聪等嘉宾加盟，与都市中各行各业的普通人同行，进入精绝古城、中缅边境、日本福岛等神秘地点，获取全新的身份。三人，七天，开始一段寻找自我的旅程。","album_type":"2"},{"album_id":"18328","album_name":"表姐到底是谁","album_logo":"http://pic.qingting.fm/2016/0808/20160808160328872.jpg!400","album_describe":"【火爆完本】 该文以第一人称讲述了主人公\u201c杜上丰\u201d某次回到家里时，发现原本温柔的表姐变得极其恐怖。被吓坏的\u201c杜上丰\u201d连夜逃离这个恐怖的家。之后我遇到了一系列诡异的故事。明明已经搬家，房子已经被拆的同学阿福突然出现在了已经被拆，现在已不存在的住宅里，在路上无意遇到的大学同学李秀臣真是无意碰到的吗？","album_type":"2"},{"album_id":"20215","album_name":"纯音乐 - 我们曾经是谁","album_logo":"http://pic.qingting.fm/2016/0810/20160810144413515.jpg!400","album_describe":"专辑以钢琴作为主旋乐器，从专辑名称的字面上理解应该算是治愈系的音乐吧！听完以后的的确确名捕其实，有一种追溯过去美好之感，心里的烦躁在这唯美的旋律下渐渐的变得无影无踪！绝对是冲洗一天'沉淀'的上乘之作！","album_type":"2"},{"album_id":"20323","album_name":"神秘前女友的邀约：谁是恶魔","album_logo":"http://pic.qingting.fm/2015/0113/20150113032550563.jpg!400","album_describe":"前女友父亲突然离世，是意外？还是阴谋？前女友深陷遗产门纠纷，身为律师如何拯救前女友出海？当真相即将浮出水面，正牌女友却惨遭毒手。年轻的小律师纠缠于美女们的感情世界里，他该如何抽丝剥茧破解这连环案？","album_type":"2"},{"album_id":"20929","album_name":"听谁在唱歌","album_logo":"http://pic.qingting.fm/2016/0616/20160616110931531.jpg!400","album_describe":"娓娓道来，细细聆听。感知旋律，未必熟悉歌者，在旋律之中深深聆听，在聆听之余细细品味。 ","album_type":"2"},{"album_id":"7736","album_name":"谁在说","album_logo":"http://pic.qingting.fm/2015/1015/20151015112552890.jpg!400","album_describe":"中国第一档故事体加论辩体的全新品牌节目。","album_type":"2"},{"album_id":"19545","album_name":"谁在你背后","album_logo":"http://pic.qingting.fm/2014/1210/20141210103715724.jpg!400","album_describe":"一位如花的女子，一个临摹古画的画家，一块美丽诡异的灵石，一幅如鲜血般绽放的昙花图案\u2026\u2026深埋在地下的石楼里，隐藏着什么不可言说的秘密？ 挑战你抵抗精神恐怖极限的文化悬疑解密小说！隐藏在未知中的恐惧，步步逼近\u2026\u2026","album_type":"2"},{"album_id":"11574","album_name":"车里都有谁","album_logo":"http://pic.qingting.fm/2016/0413/20160413180545306.jpg!400","album_describe":"史诗级非典型汽车节目，大咖云集。 关于车，扯点有意思的。 ","album_type":"2"},{"album_id":"4476","album_name":"心病谁没有","album_logo":"http://qingting-pic.b0.upaiyun.com/2014/1022/20141022104617442.jpg!400","album_describe":"随着工作、生活等各方面压力的增大，患有不同程度心理疾病的人群日益庞大。但由于传统观念，很多人不愿承认自己有病。其实，心理疾病并不可怕，可怕的是我们的观念。只有大胆说出\u201c我有病\u201d，才能真正打开心结，快乐做人。甘露春医生根据自己十多年临床经验，从众多案例人手，分析常见心理疾病的特征，介绍辨症和治疗方法，把不为人所注意的常见心病向我们娓娓道来，并就如何树立正确的健康心理观念，如何学会正确对待心理疾病等，为我们提供一把打开心锁的金钥匙。\r\n","album_type":"2"},{"album_id":"5076","album_name":"找谁倚靠","album_logo":"http://pic.qingting.fm/2015/0423/20150423144226669.jpg!400","album_describe":"我们大家都是有故事的人","album_type":"2"}]
     * type : 1
     * stringContent : 查看全部106个专辑
     * limit : 3
     */

    private String name;
    private int type;
    private String stringContent;
    private int limit;
    private List<SearchResultTypeBean> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStringContent() {
        return stringContent;
    }

    public void setStringContent(String stringContent) {
        this.stringContent = stringContent;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<SearchResultTypeBean> getList() {
        return list;
    }

    public void setList(List<SearchResultTypeBean> list) {
        this.list = list;
    }

}
