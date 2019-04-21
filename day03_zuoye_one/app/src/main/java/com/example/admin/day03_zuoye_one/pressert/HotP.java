package com.example.admin.day03_zuoye_one.pressert;

import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.base.BasePressert;
import com.example.admin.day03_zuoye_one.bean.HotBean;
import com.example.admin.day03_zuoye_one.model.HotM;
import com.example.admin.day03_zuoye_one.view.HotV;

/**
 * Created by admin on 2019/4/17.
 */

public class HotP extends BasePressert<HotV> {

    private HotM mHotM;

    @Override
    protected void initModel() {
        mHotM = new HotM();
        models.add(mHotM);
    }

    public void getData(){
        mHotM.getData(new ResultCallBack<HotBean>() {
            @Override
            public void onSuccess(HotBean bean) {
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
