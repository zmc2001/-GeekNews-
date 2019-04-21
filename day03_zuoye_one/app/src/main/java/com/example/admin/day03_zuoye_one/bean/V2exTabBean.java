package com.example.admin.day03_zuoye_one.bean;

/**
 * Created by admin on 2019/4/21.
 */

public class V2exTabBean {
    private String link;
    private String tab;

    public V2exTabBean(String link, String tab) {
        this.link = link;
        this.tab = tab;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    @Override
    public String toString() {
        return "V2exTabBean{" +
                "link='" + link + '\'' +
                ", tab='" + tab + '\'' +
                '}';
    }
}
