package com.example.admin.day03_zuoye_one.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.activity.GoldShowActivity;
import com.example.admin.day03_zuoye_one.adapter.GoldVpAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.base.Constants;
import com.example.admin.day03_zuoye_one.bean.GoldBean;
import com.example.admin.day03_zuoye_one.pressert.GoldP;
import com.example.admin.day03_zuoye_one.view.GoldV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 1808A邢鑫鑫
 * Created by admin on 2019/4/3.
 */

public class GoldFragment extends BaseFragment<GoldV, GoldP> implements GoldV {
    @BindView(R.id.gold_tab)
    TabLayout goldTab;
    @BindView(R.id.gold_vp)
    ViewPager goldVp;
    @BindView(R.id.gold_img)
    ImageView goldImg;
    private ArrayList<GoldBean> mTitles;
    private ArrayList<Fragment> mFragments;

    @Override
    protected GoldP initPressert() {
        return new GoldP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView() {
        super.initView();
        initTitle();
        setFragment();
    }

    private void setFragment() {
        initFragments();
        GoldVpAdapter goldVpAdapter = new GoldVpAdapter(getChildFragmentManager(), mFragments, mTitles);
        goldVp.setAdapter(goldVpAdapter);
        goldTab.setupWithViewPager(goldVp);
    }

    @OnClick(R.id.gold_img)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.gold_img:
                go2ShowActivity();
                break;
        }
    }

    private void go2ShowActivity() {
        Intent intent = new Intent(getActivity(), GoldShowActivity.class);
        intent.putExtra(Constants.DATA,mTitles);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            if (requestCode==100 && resultCode== Activity.RESULT_OK){
                mTitles = (ArrayList<GoldBean>) data.getSerializableExtra(Constants.DATA);
                setFragment();
            }
        }
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            GoldBean goldBean = mTitles.get(i);
            if (goldBean.isCheck) {
                mFragments.add(GoldDetailFragment.newInstance(goldBean.title));
            }
        }
    }

    private void initTitle() {
        mTitles = new ArrayList<>();
        mTitles.add(new GoldBean("Android", true));
        mTitles.add(new GoldBean("ios", true));
        mTitles.add(new GoldBean("前端", true));
        mTitles.add(new GoldBean("后端", true));
        mTitles.add(new GoldBean("设计", true));
        mTitles.add(new GoldBean("产品", true));
        mTitles.add(new GoldBean("阅读", true));
        mTitles.add(new GoldBean("工具资源", true));
    }

}
