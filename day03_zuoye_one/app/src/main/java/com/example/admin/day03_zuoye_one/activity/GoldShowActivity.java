package com.example.admin.day03_zuoye_one.activity;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.base.BaseActivity;
import com.example.admin.day03_zuoye_one.base.Constants;
import com.example.admin.day03_zuoye_one.bean.GoldBean;
import com.example.admin.day03_zuoye_one.pressert.EmptyP;
import com.example.admin.day03_zuoye_one.view.EmptyV;

import java.util.ArrayList;

import butterknife.BindView;

public class GoldShowActivity extends BaseActivity<EmptyV, EmptyP> implements EmptyV {

    @BindView(R.id.gold_show_rlv)
    RecyclerView goldShowRlv;
    @BindView(R.id.gold_show_tb)
    Toolbar goldShowTb;
    private ArrayList<GoldBean> mList;

    @Override
    protected EmptyP initPressert() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gold_show;
    }

    @Override
    protected void initView() {
        super.initView();

        goldShowTb.setTitle("首页特别展示");
        setSupportActionBar(goldShowTb);
        goldShowTb.setNavigationIcon(R.mipmap.ic_close);
        goldShowTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishv();
            }
        });

        mList = (ArrayList<GoldBean>) getIntent().getSerializableExtra(Constants.DATA);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        goldShowRlv.setLayoutManager(linearLayoutManager);
        GoldShowRlvAdapter goldShowRlvAdapter = new GoldShowRlvAdapter(this, mList);
        goldShowRlv.setAdapter(goldShowRlvAdapter);
        goldShowRlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void finishv() {
        Intent intent = getIntent();
        intent.putExtra(Constants.DATA,mList);
        setResult(RESULT_OK,intent);
        finish();
    }

}
