package com.example.admin.day03_zuoye_one.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.WeCharRlvAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.bean.WeCharBean;
import com.example.admin.day03_zuoye_one.pressert.WeChatP;
import com.example.admin.day03_zuoye_one.view.WeChatV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2019/4/3.
 */

public class WeChatFragment extends BaseFragment<WeChatV, WeChatP> implements WeChatV {
    @BindView(R.id.wechar_rlv)
    RecyclerView wecharRlv;
    private ArrayList<WeCharBean.NewslistBean> mNewslistBeans;
    private WeCharRlvAdapter mWeCharRlvAdapter;

    @Override
    protected WeChatP initPressert() {
        return new WeChatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        wecharRlv.setLayoutManager(linearLayoutManager);
        mNewslistBeans = new ArrayList<>();
        mWeCharRlvAdapter = new WeCharRlvAdapter(getActivity(), mNewslistBeans);
        wecharRlv.setAdapter(mWeCharRlvAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        pressert.getData();
    }

    @Override
    public void setData(WeCharBean bean) {
        List<WeCharBean.NewslistBean> newslist = bean.getNewslist();
        mNewslistBeans.addAll(newslist);
        mWeCharRlvAdapter.notifyDataSetChanged();
    }

}
