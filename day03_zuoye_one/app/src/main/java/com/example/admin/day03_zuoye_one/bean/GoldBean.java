package com.example.admin.day03_zuoye_one.bean;

import java.io.Serializable;

/**
 * Created by admin on 2019/4/18.
 */

public class GoldBean implements Serializable{
    public String title;
    public boolean isCheck;

    public GoldBean(String title, boolean isCheck) {
        this.title = title;
        this.isCheck = isCheck;
    }
}
