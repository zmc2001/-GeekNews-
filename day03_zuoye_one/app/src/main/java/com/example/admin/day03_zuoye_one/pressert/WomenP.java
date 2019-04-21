package com.example.admin.day03_zuoye_one.pressert;

import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.base.BasePressert;
import com.example.admin.day03_zuoye_one.bean.WomenBean;
import com.example.admin.day03_zuoye_one.model.WomenM;
import com.example.admin.day03_zuoye_one.view.WomenV;

/**
 * Created by admin on 2019/4/19.
 */

public class WomenP extends BasePressert<WomenV> {

    private WomenM mWomenM;

    @Override
    protected void initModel() {
        mWomenM = new WomenM();
        models.add(mWomenM);
    }

    public void getData(){
        mWomenM.getData(new ResultCallBack<WomenBean>() {
            @Override
            public void onSuccess(WomenBean bean) {
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
