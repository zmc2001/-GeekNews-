package com.example.admin.day03_zuoye_one.model;

import com.example.admin.day03_zuoye_one.api.BaseObserver;
import com.example.admin.day03_zuoye_one.api.HttpUtils;
import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.api.RxUtils;
import com.example.admin.day03_zuoye_one.api.ZhihuServer;
import com.example.admin.day03_zuoye_one.base.BaseModel;
import com.example.admin.day03_zuoye_one.bean.SpecialBean;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2019/4/17.
 */

public class SpecialM extends BaseModel {
    public void getData(final ResultCallBack<SpecialBean> callBack){
        ZhihuServer apiserver = HttpUtils.getInstance().getApiserver(ZhihuServer.sBaseUrl, ZhihuServer.class);
        Observable<SpecialBean> lastSpecial = apiserver.getLastSpecial();
        lastSpecial.compose(RxUtils.<SpecialBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SpecialBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SpecialBean bean) {
                        callBack.onSuccess(bean);
                    }
                });
    }
}
