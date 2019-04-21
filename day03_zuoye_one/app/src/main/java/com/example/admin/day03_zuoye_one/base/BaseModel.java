package com.example.admin.day03_zuoye_one.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by admin on 2019/4/2.
 */

public class BaseModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public void onDestory() {
        //切换所有的Disposable对象
        mCompositeDisposable.clear();
    }
}
