package com.example.admin.day03_zuoye_one.model;

import com.example.admin.day03_zuoye_one.api.BaseObserver;
import com.example.admin.day03_zuoye_one.api.HttpUtils;
import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.api.RxUtils;
import com.example.admin.day03_zuoye_one.api.ZhihuServer;
import com.example.admin.day03_zuoye_one.base.BaseModel;
import com.example.admin.day03_zuoye_one.bean.HotBean;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2019/4/17.
 */

public class HotM extends BaseModel {
    public void getData(final ResultCallBack<HotBean> callBack){
        ZhihuServer apiserver = HttpUtils.getInstance().getApiserver(ZhihuServer.sBaseUrl, ZhihuServer.class);
        Observable<HotBean> lastHot = apiserver.getLastHot();
        lastHot.compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callBack.onSuccess(hotBean);
                    }
                });
    }
}
