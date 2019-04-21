package com.example.admin.day03_zuoye_one.bean;

/**
 * Created by admin on 2019/4/21.
 */

public class V2exListBean {
    public String img;
    public String antor;
    public String time;
    public String secoudTab;
    public String title;
    public String count;

    @Override
    public String toString() {
        return "V2exListBean{" +
                "img='" + img + '\'' +
                ", antor='" + antor + '\'' +
                ", time='" + time + '\'' +
                ", secoudTab='" + secoudTab + '\'' +
                ", title='" + title + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public V2exListBean() {
    }

    public String getImg() {

        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAntor() {
        return antor;
    }

    public void setAntor(String antor) {
        this.antor = antor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSecoudTab() {
        return secoudTab;
    }

    public void setSecoudTab(String secoudTab) {
        this.secoudTab = secoudTab;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public V2exListBean(String img, String antor, String time, String secoudTab, String title, String count) {

        this.img = img;
        this.antor = antor;
        this.time = time;
        this.secoudTab = secoudTab;
        this.title = title;
        this.count = count;
    }
}
