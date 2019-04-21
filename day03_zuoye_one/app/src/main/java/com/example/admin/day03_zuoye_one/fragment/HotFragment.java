package com.example.admin.day03_zuoye_one.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.HotRlvAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.bean.HotBean;
import com.example.admin.day03_zuoye_one.pressert.HotP;
import com.example.admin.day03_zuoye_one.view.HotV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HotFragment extends BaseFragment<HotV, HotP> implements HotV {

    @BindView(R.id.hotrlv)
    RecyclerView hotrlv;
    private HotRlvAdapter mHotRlvAdapter;
    private ArrayList<HotBean.RecentBean> mList;

    @Override
    protected HotP initPressert() {
        return new HotP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        hotrlv.setLayoutManager(linearLayoutManager);
        mList = new ArrayList<>();
        mHotRlvAdapter = new HotRlvAdapter(getActivity(), mList);
        hotrlv.setAdapter(mHotRlvAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        pressert.getData();
    }

    @Override
    public void setData(HotBean hotBean) {
        List<HotBean.RecentBean> recent = hotBean.getRecent();
        mList.addAll(recent);
        mHotRlvAdapter.notifyDataSetChanged();
    }
}
