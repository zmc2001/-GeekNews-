package com.example.admin.day03_zuoye_one.pressert;

import android.text.TextUtils;
import android.util.Log;

import com.example.admin.day03_zuoye_one.api.LoginCallBack;
import com.example.admin.day03_zuoye_one.base.BasePressert;
import com.example.admin.day03_zuoye_one.bean.LoginBean;
import com.example.admin.day03_zuoye_one.model.LoginM;
import com.example.admin.day03_zuoye_one.view.LoginView;

/**
 * Created by admin on 2019/4/2.
 */

public class LoginP extends BasePressert<LoginView> {

    private LoginM mainM;

    public void getData(){
        String data = "请求回来的数据";
        if (mMainView!=null){
            mMainView.setData(data);
        }
    }

    public void login(){
        String userName = mMainView.getUserName();
        String psd = mMainView.getPsd();

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(psd)){
            mMainView.showToast("账号或密码不能为空");
            return;
        }

        mainM.login(userName, psd, new LoginCallBack() {
            @Override
            public void chenggong(LoginBean loginBean) {
                if (loginBean != null){
                    Log.i("tag","loginBean=====>"+loginBean.toString());
                    if (loginBean.getCode()==200){
                        if (mMainView!=null){
                            mMainView.showToast("登录成功");
                        }
                    }else {
                        if (mMainView!=null){
                            mMainView.showToast("登录失败");
                        }
                    }
                }
            }

            @Override
            public void shibai(String str) {
                if (mMainView!=null){
                    mMainView.showToast("登录失败");
                    Log.i("tag","登录失败=====>"+str);
                }
            }
        });
    }

    @Override
    protected void initModel() {
        mainM = new LoginM();
        models.add(mainM);
    }
}
