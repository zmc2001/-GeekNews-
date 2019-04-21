package com.example.admin.day03_zuoye_one.fragment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.activity.CalendarActivity;
import com.example.admin.day03_zuoye_one.adapter.ZhihuVpAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.pressert.ZhiHuP;
import com.example.admin.day03_zuoye_one.view.ZhiHuV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by admin on 2019/4/3.
 * 1808A邢鑫鑫
 */

public class ZhiHuFragment extends BaseFragment<ZhiHuV, ZhiHuP> implements ZhiHuV {
    @BindView(R.id.zhihu_tab)
    TabLayout zhihuTab;
    @BindView(R.id.zhihu_vp)
    ViewPager zhihuVp;
    @BindView(R.id.floatbutton)
    FloatingActionButton fab;
    private ArrayList<Integer> mTitles;
    private ArrayList<Fragment> mFragments;

    @Override
    protected ZhiHuP initPressert() {
        return new ZhiHuP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initView() {
        super.initView();
        initTitles();
        initFragments();
        ZhihuVpAdapter zhihuVpAdapter = new ZhihuVpAdapter(getChildFragmentManager(), mFragments, mTitles, getActivity());
        zhihuVp.setAdapter(zhihuVpAdapter);
        zhihuTab.setupWithViewPager(zhihuVp);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new DailyNewsFragment());
        mFragments.add(new ZhutiFragment());
        mFragments.add(new SpecialFragment());
        mFragments.add(new HotFragment());
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(R.string.dailyNews);
        mTitles.add(R.string.zhuti);
        mTitles.add(R.string.special);
        mTitles.add(R.string.hot);
    }

    @Override
    protected void initListener() {
        super.initListener();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalendarActivity.class));
            }
        });
    }
}
