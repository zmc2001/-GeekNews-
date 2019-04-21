package com.example.admin.day03_zuoye_one.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.SpecialRlvAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.bean.SpecialBean;
import com.example.admin.day03_zuoye_one.pressert.SpecialP;
import com.example.admin.day03_zuoye_one.view.SpecialV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SpecialFragment extends BaseFragment<SpecialV, SpecialP> implements SpecialV {

    @BindView(R.id.special_rlv)
    RecyclerView specialRlv;
    private SpecialRlvAdapter mSpecialRlvAdapter;
    private ArrayList<SpecialBean.DataBean> mList;

    @Override
    protected SpecialP initPressert() {
        return new SpecialP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initView() {
        super.initView();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        specialRlv.setLayoutManager(gridLayoutManager);
        mList = new ArrayList<>();
        mSpecialRlvAdapter = new SpecialRlvAdapter(getActivity(), mList);
        specialRlv.setAdapter(mSpecialRlvAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        pressert.getData();
    }

    @Override
    public void setData(SpecialBean bean) {
        List<SpecialBean.DataBean> data = bean.getData();
        mList.addAll(data);
        mSpecialRlvAdapter.notifyDataSetChanged();
    }

}
