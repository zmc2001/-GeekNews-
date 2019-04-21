package com.example.admin.day03_zuoye_one.fragment;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.pressert.EmptyP;
import com.example.admin.day03_zuoye_one.view.EmptyV;

/**
 * Created by admin on 2019/4/3.
 */

public class AboutFragment extends BaseFragment<EmptyV,EmptyP> implements EmptyV{
    @Override
    protected EmptyP initPressert() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }
}
