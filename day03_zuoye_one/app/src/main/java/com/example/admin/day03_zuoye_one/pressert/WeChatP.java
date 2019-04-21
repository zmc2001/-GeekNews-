package com.example.admin.day03_zuoye_one.pressert;

import com.example.admin.day03_zuoye_one.api.ResultCallBack;
import com.example.admin.day03_zuoye_one.base.BasePressert;
import com.example.admin.day03_zuoye_one.bean.WeCharBean;
import com.example.admin.day03_zuoye_one.model.WeCharM;
import com.example.admin.day03_zuoye_one.view.WeChatV;

/**
 * Created by admin on 2019/4/3.
 */

public class WeChatP extends BasePressert<WeChatV> {

    private WeCharM mWeCharM;

    @Override
    protected void initModel() {
        mWeCharM = new WeCharM();
        models.add(mWeCharM);
    }

    public void getData(){
        mWeCharM.getData(new ResultCallBack<WeCharBean>() {
            @Override
            public void onSuccess(WeCharBean bean) {
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
