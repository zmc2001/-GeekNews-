package com.example.admin.day03_zuoye_one.api;

import com.example.admin.day03_zuoye_one.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by admin on 2019/4/2.
 */

public interface MyServer {
    String url = "http://yun918.cn/study/public/index.php/";
    @POST("login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("username") String username,@Field("password") String password);
}
