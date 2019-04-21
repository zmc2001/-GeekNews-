package com.example.admin.day03_zuoye_one.api;

import com.example.admin.day03_zuoye_one.bean.DailyNewsBean;
import com.example.admin.day03_zuoye_one.bean.HotBean;
import com.example.admin.day03_zuoye_one.bean.SpecialBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by admin on 2019/4/17.
 */

public interface ZhihuServer {
    String sBaseUrl = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<DailyNewsBean> getLastDailyNews();

    @GET("news/hot")
    Observable<HotBean> getLastHot();

    @GET("sections")
    Observable<SpecialBean> getLastSpecial();
}
