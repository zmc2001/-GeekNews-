package com.example.admin.day03_zuoye_one.pressert;

import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.base.BasePressert;
import com.example.admin.day03_zuoye_one.bean.SpecialBean;
import com.example.admin.day03_zuoye_one.model.SpecialM;
import com.example.admin.day03_zuoye_one.view.SpecialV;

/**
 * Created by admin on 2019/4/17.
 */

public class SpecialP extends BasePressert<SpecialV> {

    private SpecialM mSpecialM;

    @Override
    protected void initModel() {
        mSpecialM = new SpecialM();
        models.add(mSpecialM);
    }
    public void getData(){
        mSpecialM.getData(new ResultCallBack<SpecialBean>() {
            @Override
            public void onSuccess(SpecialBean bean) {
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
