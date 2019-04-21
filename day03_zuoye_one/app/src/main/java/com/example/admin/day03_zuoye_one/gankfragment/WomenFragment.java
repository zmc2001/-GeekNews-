package com.example.admin.day03_zuoye_one.gankfragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.WomenRlvAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.bean.WomenBean;
import com.example.admin.day03_zuoye_one.pressert.WomenP;
import com.example.admin.day03_zuoye_one.view.WomenV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WomenFragment extends BaseFragment<WomenV, WomenP> implements WomenV {

    @BindView(R.id.women_rlv)
    RecyclerView womenRlv;
    private ArrayList<WomenBean.ResultsBean> mList;
    private WomenRlvAdapter mWomenRlvAdapter;

    @Override
    protected WomenP initPressert() {
        return new WomenP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_women;
    }

    @Override
    protected void initView() {
        super.initView();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        womenRlv.setLayoutManager(gridLayoutManager);
        mList = new ArrayList<>();
        mWomenRlvAdapter = new WomenRlvAdapter(getActivity(), mList);
        womenRlv.setAdapter(mWomenRlvAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        pressert.getData();
    }

    @Override
    public void setData(WomenBean bean) {
        List<WomenBean.ResultsBean> results = bean.getResults();
        mList.addAll(results);
        mWomenRlvAdapter.notifyDataSetChanged();
    }

}
