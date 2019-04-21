package com.example.admin.day03_zuoye_one.activity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.base.BaseActivity;
import com.example.admin.day03_zuoye_one.pressert.EmptyP;
import com.example.admin.day03_zuoye_one.view.EmptyV;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import butterknife.BindView;

public class CalendarActivity extends BaseActivity<EmptyV, EmptyP> implements EmptyV {
    @BindView(R.id.calendarView)
    MaterialCalendarView calendarView;
    @BindView(R.id.tab)
    Toolbar tab;

    @Override
    protected EmptyP initPressert() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rili;
    }

    @Override
    protected void initData() {
        tab.setTitle("");
        setSupportActionBar(tab);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        //getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
//        getSupportActionBar().setTitle("选择日期");
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);
//        getActionBar().setTitle("选择日期");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
    }

    //设置监听事件,点击返回按钮则退出当前页面
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}
