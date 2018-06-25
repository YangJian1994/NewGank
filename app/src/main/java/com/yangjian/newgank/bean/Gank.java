package com.yangjian.newgank.bean;

import java.io.Serializable;

/**
 * Created by Yang on 2018/6/22.
 * Function：
 */

public class Gank implements Serializable {
    /**
     * who: "lijinshanmx"
     * used: true
     * url: "http://ww1.sinaimg.cn/large/0065oQSqly1frslruxdr1j30j60ok79c.jpg"
     * type: "福利"
     * source: "web"
     * publishedAt: "2018-06-22T00:00:00.0Z"
     * desc: "2018-06-02"
     * createdAt: "2018-05-29T22:59:12.622Z"
     * _id: "5b0d6ac0421aa97efda86560"
     */

    private String who;
    private boolean used;
    private String url;
    private String type;
    private String source;
    private String publishedAt;
    private String desc;
    private String createdAt;
    private String _id;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
