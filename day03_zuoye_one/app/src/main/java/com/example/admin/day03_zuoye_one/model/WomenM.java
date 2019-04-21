package com.example.admin.day03_zuoye_one.model;

import com.example.admin.day03_zuoye_one.api.BaseObserver;
import com.example.admin.day03_zuoye_one.api.GankServer;
import com.example.admin.day03_zuoye_one.api.HttpUtils;
import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.api.RxUtils;
import com.example.admin.day03_zuoye_one.base.BaseModel;
import com.example.admin.day03_zuoye_one.bean.WomenBean;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2019/4/19.
 */

public class WomenM extends BaseModel {
    public void getData(final ResultCallBack<WomenBean> callBack){
        GankServer apiserver = HttpUtils.getInstance().getApiserver(GankServer.womenurl, GankServer.class);
        Observable<WomenBean> womenData = apiserver.womenData();
        womenData.compose(RxUtils.<WomenBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WomenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WomenBean womenBean) {
                        callBack.onSuccess(womenBean);
                    }
                });
    }
}
