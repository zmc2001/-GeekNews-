package com.example.admin.day03_zuoye_one.api;

import com.example.admin.day03_zuoye_one.bean.LoginBean;

/**
 * Created by admin on 2019/4/2.
 */

public interface LoginCallBack {
    void chenggong(LoginBean loginBean);
    void shibai(String str);
}
