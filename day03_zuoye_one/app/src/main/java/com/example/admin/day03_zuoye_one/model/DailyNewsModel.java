package com.example.admin.day03_zuoye_one.model;

import com.example.admin.day03_zuoye_one.api.BaseObserver;
import com.example.admin.day03_zuoye_one.api.HttpUtils;
import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.api.RxUtils;
import com.example.admin.day03_zuoye_one.api.ZhihuServer;
import com.example.admin.day03_zuoye_one.base.BaseModel;
import com.example.admin.day03_zuoye_one.bean.DailyNewsBean;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2019/4/17.
 */

public class DailyNewsModel extends BaseModel {
    public void getData(final ResultCallBack<DailyNewsBean> callBack){
        ZhihuServer server = HttpUtils.getInstance().getApiserver(ZhihuServer.sBaseUrl, ZhihuServer.class);
        Observable<DailyNewsBean> lastDailyNews = server.getLastDailyNews();
        lastDailyNews.compose(RxUtils.<DailyNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        callBack.onSuccess(dailyNewsBean);
                    }
                });
    }
}
