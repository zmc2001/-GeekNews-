package com.example.admin.day03_zuoye_one.api;

import com.example.admin.day03_zuoye_one.bean.WeCharBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by admin on 2019/4/18.
 */

public interface WeCahrServer {
    String urljx = "http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WeCharBean> getData();
}
