package com.example.admin.day03_zuoye_one.model;

import com.example.admin.day03_zuoye_one.api.BaseObserver;
import com.example.admin.day03_zuoye_one.api.HttpUtils;
import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.api.RxUtils;
import com.example.admin.day03_zuoye_one.api.WeCahrServer;
import com.example.admin.day03_zuoye_one.base.BaseModel;
import com.example.admin.day03_zuoye_one.bean.WeCharBean;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2019/4/18.
 */

public class WeCharM extends BaseModel {
    public void getData(final ResultCallBack<WeCharBean> callBack){
        WeCahrServer apiserver = HttpUtils.getInstance().getApiserver(WeCahrServer.urljx, WeCahrServer.class);
        Observable<WeCharBean> data = apiserver.getData();
        data.compose(RxUtils.<WeCharBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeCharBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WeCharBean weCharBean) {
                        callBack.onSuccess(weCharBean);
                    }
                });
    }
}
