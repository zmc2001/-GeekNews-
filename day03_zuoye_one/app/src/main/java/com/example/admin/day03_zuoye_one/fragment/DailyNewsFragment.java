package com.example.admin.day03_zuoye_one.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.DailyNewsRlvAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.bean.DailyNewsBean;
import com.example.admin.day03_zuoye_one.pressert.DailyNewsPresenter;
import com.example.admin.day03_zuoye_one.view.DailyNewsView;

import java.util.ArrayList;

import butterknife.BindView;

public class DailyNewsFragment extends BaseFragment<DailyNewsView, DailyNewsPresenter> implements DailyNewsView {

    @BindView(R.id.dailyNews_rlv)
    RecyclerView dailyNewsRlv;
    private DailyNewsRlvAdapter mDailyNewsRlvAdapter;

    @Override
    protected DailyNewsPresenter initPressert() {
        return new DailyNewsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_news;
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        dailyNewsRlv.setLayoutManager(linearLayoutManager);
        ArrayList<DailyNewsBean.StoriesBean> storiesBeans = new ArrayList<>();
        ArrayList<DailyNewsBean.TopStoriesBean> topStoriesBeans = new ArrayList<>();
        mDailyNewsRlvAdapter = new DailyNewsRlvAdapter(getActivity(), storiesBeans, topStoriesBeans);
        dailyNewsRlv.setAdapter(mDailyNewsRlvAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        pressert.getData();
    }

    @Override
    public void setData(DailyNewsBean bean) {
        mDailyNewsRlvAdapter.setData(bean);
    }
}
