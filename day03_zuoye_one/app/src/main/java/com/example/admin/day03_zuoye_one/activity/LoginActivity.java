package com.example.admin.day03_zuoye_one.activity;

import android.widget.Button;
import android.widget.EditText;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.base.BaseActivity;
import com.example.admin.day03_zuoye_one.pressert.LoginP;
import com.example.admin.day03_zuoye_one.util.ToastUtil;
import com.example.admin.day03_zuoye_one.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

//1808A邢鑫鑫
public class LoginActivity extends BaseActivity<LoginView,LoginP> implements LoginView {
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.ed_name)
    EditText ed_name;
    @BindView(R.id.ed_pwd)
    EditText ed_pwd;

    @Override
    public void setData(String data) {
        btn.setText(data);
    }

    @Override
    public String getUserName() {
        return ed_name.getText().toString().trim();
    }

    @Override
    public String getPsd() {
        return ed_pwd.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showShort(msg);
    }

    @OnClick({R.id.btn})
    public void Click(){
        pressert.login();
    }

    @Override
    protected LoginP initPressert() {
        return new LoginP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}
