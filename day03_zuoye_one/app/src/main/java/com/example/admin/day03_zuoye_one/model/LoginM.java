package com.example.admin.day03_zuoye_one.model;

import com.example.admin.day03_zuoye_one.api.LoginCallBack;
import com.example.admin.day03_zuoye_one.api.MyServer;
import com.example.admin.day03_zuoye_one.base.BaseModel;
import com.example.admin.day03_zuoye_one.bean.LoginBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2019/4/2.
 */

public class LoginM extends BaseModel{
    public void login(String userName, String psd, final LoginCallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<LoginBean> login = myServer.login(userName, psd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (loginBean!=null){
                            if (loginBean.getCode()==200){
                                callBack.chenggong(loginBean);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.shibai(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
