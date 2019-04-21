package com.example.admin.day03_zuoye_one.view;

import com.example.admin.day03_zuoye_one.base.BaseView;

/**
 * Created by admin on 2019/4/2.
 */

public interface LoginView extends BaseView{
    void setData(String data);

    String getUserName();
    String getPsd();

    void showToast(String msg);
}
