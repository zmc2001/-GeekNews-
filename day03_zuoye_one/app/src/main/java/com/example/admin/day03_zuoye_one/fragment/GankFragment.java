package com.example.admin.day03_zuoye_one.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.GankVpAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.gankfragment.AndroidFragment;
import com.example.admin.day03_zuoye_one.gankfragment.FrontFragment;
import com.example.admin.day03_zuoye_one.gankfragment.IosFragment;
import com.example.admin.day03_zuoye_one.gankfragment.WomenFragment;
import com.example.admin.day03_zuoye_one.pressert.GankP;
import com.example.admin.day03_zuoye_one.view.GankV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by admin on 2019/4/3.
 * 1808A邢鑫鑫
 */

public class GankFragment extends BaseFragment<GankV, GankP> implements GankV {
    @BindView(R.id.gank_tab)
    TabLayout gankTab;
    @BindView(R.id.gank_vp)
    ViewPager gankVp;
    private ArrayList<String> mTitles;
    private ArrayList<Fragment> mFragments;

    @Override
    protected GankP initPressert() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initView() {
        super.initView();
        initTitles();
        initFragments();
        GankVpAdapter gankVpAdapter = new GankVpAdapter(getChildFragmentManager(), mFragments, mTitles);
        gankVp.setAdapter(gankVpAdapter);
        gankTab.setupWithViewPager(gankVp);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new AndroidFragment());
        mFragments.add(new IosFragment());
        mFragments.add(new FrontFragment());
        mFragments.add(new WomenFragment());
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add("ANDROID");
        mTitles.add("IOS");
        mTitles.add("前端");
        mTitles.add("福利");
    }
}
