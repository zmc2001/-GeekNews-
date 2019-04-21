package com.example.admin.day03_zuoye_one.pressert;

import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.base.BasePressert;
import com.example.admin.day03_zuoye_one.bean.DailyNewsBean;
import com.example.admin.day03_zuoye_one.model.DailyNewsModel;
import com.example.admin.day03_zuoye_one.view.DailyNewsView;

/**
 * Created by admin on 2019/4/17.
 */

public class DailyNewsPresenter extends BasePressert<DailyNewsView> {

    private DailyNewsModel mDailyNewsModel;

    @Override
    protected void initModel() {
        mDailyNewsModel = new DailyNewsModel();
        models.add(mDailyNewsModel);
    }

    public void getData(){
        mDailyNewsModel.getData(new ResultCallBack<DailyNewsBean>() {
            @Override
            public void onSuccess(DailyNewsBean bean) {
                if (bean!=null){
                    if (mMainView!=null){
                        mMainView.setData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
