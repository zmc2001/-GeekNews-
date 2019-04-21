package com.example.admin.day03_zuoye_one.base;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/2.
 */

public abstract class BasePressert<V extends BaseView> {
    protected V mMainView;
    protected ArrayList<BaseModel> models = new ArrayList<>();

    public BasePressert() {
        initModel();
    }

    protected abstract void initModel();

    public void bind(V view){
        this.mMainView = view;
    }

    public void onDestory(){
        mMainView = null;
        for (BaseModel model : models) {
            model.onDestory();
        }
        models.clear();
    }
}
