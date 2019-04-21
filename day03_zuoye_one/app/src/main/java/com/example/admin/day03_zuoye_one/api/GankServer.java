package com.example.admin.day03_zuoye_one.api;

import com.example.admin.day03_zuoye_one.bean.WomenBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by admin on 2019/4/19.
 */

public interface GankServer {
    String womenurl = "http://gank.io/api/data/福利/";
    @GET("10/1")
    Observable<WomenBean> womenData();
}
