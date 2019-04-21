package com.example.admin.day03_zuoye_one.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by admin on 2019/4/2.
 */

public abstract class BaseActivity<V extends BaseView,P extends BasePressert>
        extends AppCompatActivity implements BaseView{

    protected P pressert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //找布局
        setContentView(getLayoutId());
        //找id
        ButterKnife.bind(this);
        pressert = initPressert();
        if (pressert != null){
            pressert.bind((V)this);
        }
        initView();
        initListener();
        initData();
    }

    protected abstract P initPressert();

    protected void initData(){};

    protected void initListener(){};

    protected void initView(){};

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pressert.onDestory();
        pressert = null;
    }
}
