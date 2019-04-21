package com.example.admin.day03_zuoye_one.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.day03_zuoye_one.bean.GoldBean;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/18.
 */

public class GoldVpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<GoldBean> title;
    private ArrayList<String> list = new ArrayList<>();

    public GoldVpAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<GoldBean> title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;

        for (int i = 0; i < title.size(); i++) {
            GoldBean goldBean = title.get(i);
            if (goldBean.isCheck){
                list.add(goldBean.title);
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
