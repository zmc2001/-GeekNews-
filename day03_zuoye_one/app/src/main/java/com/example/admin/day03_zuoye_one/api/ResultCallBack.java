package com.example.admin.day03_zuoye_one.api;

/**
 * Created by admin on 2019/4/17.
 */

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFail(String msg);
}
