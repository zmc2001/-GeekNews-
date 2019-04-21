package com.example.admin.day03_zuoye_one.fragment;


import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.base.Constants;
import com.example.admin.day03_zuoye_one.pressert.EmptyP;
import com.example.admin.day03_zuoye_one.view.EmptyV;

import butterknife.BindView;

public class GoldDetailFragment extends BaseFragment<EmptyV, EmptyP> implements EmptyV {

    @BindView(R.id.gold_detail_tv)
    TextView goldDetailTv;

    public static GoldDetailFragment newInstance(String text) {
        GoldDetailFragment goldDetailFragment = new GoldDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, text);
        goldDetailFragment.setArguments(bundle);
        return goldDetailFragment;
    }

    @Override
    protected EmptyP initPressert() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        Bundle arguments = getArguments();
        String string = arguments.getString(Constants.DATA);
        goldDetailTv.setText(string);
    }
}
