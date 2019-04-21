package com.example.admin.day03_zuoye_one.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/17.
 */

public class ZhihuVpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> title;
    private Context context;
    public ZhihuVpAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<Integer> title, Context context) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
        this.context = context;
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
        return context.getResources().getString(title.get(position));
    }
}
