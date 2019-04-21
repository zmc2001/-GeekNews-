package com.example.admin.day03_zuoye_one.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by admin on 2019/4/3.
 */

public abstract class BaseFragment<V extends BaseView,P extends BasePressert> extends Fragment
        implements BaseView{

    private Unbinder unbinder;
    protected P pressert;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, inflate);
        pressert = initPressert();
        if (pressert != null){
            pressert.bind((V)this);
        }
        initView();
        initListener();
        initData();
        return inflate;
    }

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract P initPressert();

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        pressert.onDestory();
        pressert=null;
    }
}
